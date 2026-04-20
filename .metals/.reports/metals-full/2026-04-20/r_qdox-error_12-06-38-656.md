error id: file:///C:/Users/Usuario/Documents/GitHub/Estudia-Ya/webapp/src/main/java/ProyectoEstudiaYa/webapp/entities/Curso.java
file:///C:/Users/Usuario/Documents/GitHub/Estudia-Ya/webapp/src/main/java/ProyectoEstudiaYa/webapp/entities/Curso.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[1,1]

error in qdox parser
file content:
```java
offset: 1
uri: file:///C:/Users/Usuario/Documents/GitHub/Estudia-Ya/webapp/src/main/java/ProyectoEstudiaYa/webapp/entities/Curso.java
text:
```scala
p@@ackage ProyectoEstudiaYa.entities.;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
 
@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Curso {

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String nombre; // Matemática, Comunicación, etc.
 
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Usuario.NivelEducativo nivel; // PRIMARIA, SECUNDARIA
 
    @Column(nullable = false)
    private Integer grado; // 1 al 6 o 1 al 5
 
    private String descripcion;
    private String colorHex;  // color por curso ej: #378ADD
    private String icono;     // emoji o nombre del icono
 
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Tema> temas;
 
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<UsuarioCurso> usuarios;
 
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Tarea> tareas;


}

```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	java.base/java.lang.Thread.run(Thread.java:840)
```
#### Short summary: 

QDox parse error in file:///C:/Users/Usuario/Documents/GitHub/Estudia-Ya/webapp/src/main/java/ProyectoEstudiaYa/webapp/entities/Curso.java