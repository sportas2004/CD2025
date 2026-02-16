# Breve descripción del proceso realizado

Decidín converter cada un deses conceptos nunha clase porque todos teñen identidade propia e atributos asociados. A partir de aí analicei como se relacionaban entre si para definir correctamente as asociacións e as cardinalidades.

Cando vin que unha conferencia pode ter varias sesións e que unha sesión non ten sentido sen unha conferencia, coloquei unha lista de sesións en `Conferencia`, o que fai que as sesións estean limitadas a unha conferencia, xa que a sesión depende estruturalmente da conferencia. Despois centreime no proceso de inscrición. Como o enunciado indica que todos os participantes deben inscribirse na conferencia, creei unha clase chamada `Inscripcion` que conecta un participante cunha conferencia e que ademais almacena o estado da inscrición, permitindo confirmala ou cancelala.

No caso dos participantes, observei que existen dous tipos, orador e público, pero ambos comparten datos comúns. Por iso creei unha clase abstracta `Participante` cos atributos xerais e dúas subclases, `Orador` e `Publico`, que se unen na relación como “é un”.

Na parte dos artigos científicos, creei a clase `Articulo` cos seus atributos básicos e un tipo enumerado para distinguir entre artigo curto e longo. Tamén engadín a clase `Autor` e establecín unha relación de moitos a moitos entre `Autor` e `Articulo`, xa que un autor pode ter varios artigos e un artigo pode ter varios autores.

Para representar o rol que desempeña unha persoa dentro dunha sesión, creei a clase `Asistencia`, que enlaza unha inscrición cunha sesión e garda o rol concreto, orador ou público.

Unha vez definido o diagrama de clases con todas as relacións e cardinalidades, trasladeino a Java creando as clases correspondentes, definindo atributos privados, construtores, métodos de acceso e métodos de comportamento. Utilicei enumeracións cando o conxunto de valores era pechado.
