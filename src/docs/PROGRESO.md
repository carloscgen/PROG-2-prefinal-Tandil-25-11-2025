# Prefinal Tandil 25/11/2025 — progreso

Enunciado: `Prefinal 2025 - Tandil.pdf` (una página). El usuario está implementando el ejercicio por etapas; revisar cada parte que presente sin adelantarle la solución completa.

## Productos y local — revisados

- `Local` tiene nombre y una lista de `Elemento`; permite agregar productos y devuelve una copia de la lista. `Elemento` no hereda de `Local`.
- `Elemento` es la abstracción común de `ProductoSimple` y `Combo`. Guarda `id` y `marca`; declara `getPrecio()` y `getCaracteristicas()` abstractos.
- `ProductoSimple` guarda el precio de lista y sus características. El constructor asigna el precio y `getCaracteristicas()` devuelve una lista nueva.
- `Combo` guarda elementos de tipo `Elemento`. Al agregarlos compara la marca del elemento con la marca del propio combo. Calcula el precio sumando los precios de los elementos y las características como unión sin repetidos, también con combos anidados.
- El enunciado no exige expresamente rechazar características repetidas al agregarlas a un producto simple. Sí exige que la unión devuelta por un combo no tenga repetidos.
- `Local.agregarProductos(Elemento)` incorpora productos a la lista del local.

## Condiciones — revisadas

- `Condicion` declara `cumple(Elemento)`, por lo que las condiciones pueden evaluar productos simples o combos mediante las operaciones comunes.
- Están implementadas las condiciones de precio superior a un límite, marca, una característica y todas las características de una lista. La condición de varias características recorre las requeridas y comprueba que cada una esté en el producto; copia la lista recibida en el constructor.
- `CondicionAND`, `CondicionOR` y `CondicionNOT` combinan condiciones. `NOT` recibe una sola condición.
- `CondicionCaracteristicas.cumple` recorre las características requeridas; una lista vacía se cumple sin necesidad de un caso especial.

## Estrategias — revisadas

- `Estrategia` mantiene una `Condicion` e implementa `cumpleCondicion(Elemento)` una sola vez; cada subtipo implementa su cálculo del descuento.
- `EstrategiaMonto` devuelve un monto fijo si cumple la condición; `EstrategiaPorcentaje` calcula un porcentaje del precio de lista; `EstrategiaMontoCaracteristica` multiplica un valor por la cantidad de características si cumple la condición. Si no cumplen, devuelven 0.
- `EstrategiaCompuesta` suma los descuentos calculados por sus dos estrategias hijas cuando cumple su propia condición. Para el ejemplo de marca «Mike» y característica «Discontinuo», esa condición debe ser un OR: así se aplica si cumple cualquiera de las dos y puede acumular ambos descuentos.
- `EstrategiaPorcentaje` y `EstrategiaMontoCaracteristica` heredan de la clase concreta `EstrategiaMonto` para reutilizar `valor`. Se discutió separar ese estado en una clase abstracta intermedia, pero no es una exigencia del enunciado ni impide resolver los ejemplos. El usuario decidió conservar la jerarquía actual.
- La condición propia de la estrategia compuesta debe ser coherente con las condiciones de sus estrategias hijas. En el ejemplo del PDF se usa `OR`.

## Servicios, copias y tipos adicionales — revisados

- `Local.estaEnPromocion` exige que el producto cumpla la condición y pertenezca a la lista del local; `pertenece` recorre la lista completa por identificador.
- `Local.precioProductoPromocion` resta el descuento al precio de lista y devuelve 0 si la resta es negativa.
- `Local.copiaProductos` combina con `addAll` las listas devueltas por cada producto. `ProductoSimple.getCopia` copia precio, identificador, marca y características mediante `copiaInicial`; la subclase limitada sobrescribe esa fábrica para conservar tipo y límite.
- `Combo.getCopia` devuelve una copia vacía del combo si el propio combo está alcanzado. En caso contrario, recorre recursivamente los hijos, agrega sus copias y devuelve el combo solo si alguno aportó elementos. La misma implementación de `Combo` cubre el comportamiento pedido para packs.
- `ProductoCaracteristicasLimitadas` usa un límite de instancia inmutable; con 10 y 3 representa las dos variantes del enunciado y rechaza nuevos agregados al llegar al límite.

## Evaluación actual

- Todas las fuentes compilaron. Se comprobaron con ejecuciones concretas los descuentos porcentual y compuesto del ejemplo, el precio final, la pertenencia, el límite de características, la conservación del tipo y datos en copias, la independencia de las copias y los tres casos de copia de combos (alcanzado, no alcanzado con descendientes alcanzados, sin descendientes alcanzados).
- La solución cubre los servicios y tipos pedidos y está en condiciones razonables para una evaluación. La unicidad de identificadores y la coherencia entre la condición de una estrategia compuesta y sus hijas quedan a cargo de quien construye los objetos; el enunciado no especifica cómo validar entradas inconsistentes.
