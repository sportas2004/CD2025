```mermaid
classDiagram
direction TB

class Conferencia {
  +String id
  +String nome
  +String lugar
  +LocalDate dataInicio
  +LocalDate dataFin
  +addSesion(s: Sesion)
  +rexistrar(i: Inscripcion)
}

class Sesion {
  +String id
  +String titulo
  +LocalDateTime inicio
  +String sala
  +addArticulo(a: Articulo)
  +engadirAsistencia(a: Asistencia)
}

class Inscripcion {
  +String id
  +EstadoInscripcion estado
  +LocalDateTime dataRexistro
  +confirmar()
  +cancelar()
}

class Asistencia {
  +RolSesion rol
  +boolean presente
}

class Participante {
  <<abstract>>
  +String id
  +String nome
  +String email
}

class Orador {
  +String afiliacion
}

class Publico {
  +String organizacion
}

class Autor {
  +String id
  +String nome
  +String afiliacion
  +String email
}

class Articulo {
  +String id
  +String titulo
  +TipoArticulo tipo
  +String tema
  +int numPaxinas
}

class TipoArticulo {
  <<enumeration>>
  CURTO
  LONGO
}

class EstadoInscripcion {
  <<enumeration>>
  PENDENTE
  CONFIRMADA
  CANCELADA
}

class RolSesion {
  <<enumeration>>
  ORADOR
  PUBLICO
}

Conferencia "1" *-- "1..*" Sesion : compón / contén
Conferencia "1" o-- "0..*" Inscripcion : admite
Inscripcion "1" --> "1" Participante : pertence a

Sesion "1" o-- "1..*" Articulo : presenta
Articulo "*" -- "*" Autor : escrito por

Sesion "1" o-- "0..*" Asistencia : ten asistentes
Asistencia "1" --> "1" Inscripcion : require inscrición
Asistencia "1" --> "1" Sesion : participación
Participante <|-- Orador : é un
Participante <|-- Publico : é un
