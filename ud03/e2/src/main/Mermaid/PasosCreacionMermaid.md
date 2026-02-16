# Breve descrición do proceso realizado

O código parte dunha plantilla xeral chamada `Persona`, que é unha clase abstracta. Polo tanto, non se poden instanciar obxectos directamente desde `Persona`, senón unicamente desde as súas subclases (`Alumno` ou `Profesor`). Estas subclases herdan os atributos e métodos comúns definidos en `Persona`.

O resto das clases modélanse de maneira habitual. Para construír o diagrama Mermaid/UML revisáronse os atributos de cada clase e marcouse a súa visibilidade con `+` (público) ou `-` (privado). O mesmo proceso aplicouse aos métodos, colocándoos na súa clase correspondente.

Finalmente, para establecer as relacións e as cardinalidades, analizáronse os atributos que fan referencia a outras clases (por exemplo, se son obxectos únicos ou arrays). En función diso, determinouse se a relación debía representarse como `1`, `0..[0-100]` ou `0..*`.
