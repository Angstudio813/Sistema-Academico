package ProyectoEstudiaYa.webapp.controller;

import ProyectoEstudiaYa.webapp.entities.Usuario;
import ProyectoEstudiaYa.webapp.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;

import java.util.NoSuchElementException;
import java.nio.charset.StandardCharsets;

@Controller
public class AuthSessionController {

    private final UsuarioService usuarioService;

    public AuthSessionController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam("username") String email,
            @RequestParam("password") String password,
            @RequestParam(value = "next", required = false) String next,
            HttpSession session) {

        try {
            Usuario usuario = usuarioService.obtenerPorEmail(email);

            if (usuario.getPassword() != null && usuario.getPassword().equals(password)) {
                session.setAttribute("usuarioId", usuario.getId());
                session.setAttribute("usuarioEmail", usuario.getEmail());
                session.setAttribute("usuarioNombre", usuario.getNombre());

                if (next != null && !next.isBlank() && next.startsWith("/")) {
                    String decoded = UriUtils.decode(next, StandardCharsets.UTF_8);
                    return "redirect:" + decoded;
                }

                return "redirect:/";
            }

            return "redirect:/login?error";
        } catch (NoSuchElementException ex) {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}
