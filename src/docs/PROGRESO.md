# Prefinal Tandil 25/11/2025 — progreso

Enunciado: `Prefinal 2025 - Tandil.pdf` (una página). El usuario está implementando el ejercicio por etapas; revisar cada parte que presente sin adelantarle la solución completa.

## Productos y local — revisados

- `Local` tiene nombre y una lista de `Elemento`; permite agregar productos y devuelve una copia de la lista. `Elemento` no hereda de `Local`.
- `Elemento` es la abstracción común de `ProductoSimple` y `Combo`. Guarda `id` y `marca`; declara `getPrecio()` y `getCaracteristicas()` abstractos.
- `ProductoSimple` guarda el precio de lista y sus características. El constructor asigna el precio y `getCaracteristicas()` devuelve una lista nueva.
- `Combo` guarda elementos de tipo `Elemento`. Al agregarlos compara la marca del elemento con la marca del propio combo. Calcula el precio sumando los precios de los elementos y las características como unión sin repetidos, también con combos anidados.
- El enunciado no exige expresamente rechazar características repetidas al agregarlas a un producto simple. Sí exige que la unión devuelta por un combo no tenga repetidos.
- Mejora de nombre pendiente: `Local.setProductos(Elemento)` agrega un producto; `agregarProducto` expresaría mejor su comportamiento.

## Condiciones — revisadas

- `Condicion` declara `cumple(Elemento)`, por lo que las condiciones pueden evaluar productos simples o combos mediante las operaciones comunes.
- Están implementadas las condiciones de precio superior a un límite, marca, una característica y todas las características de una lista. La condición de varias características recorre las requeridas y comprueba que cada una esté en el producto; copia la lista recibida en el constructor.
- `CondicionAND`, `CondicionOR` y `CondicionNOT` combinan condiciones. `NOT` recibe una sola condición.
- En `CondicionCaracteristicas.cumple`, el control previo de lista vacía es redundante, pero el comportamiento es correcto.

## Pendiente

- `Estrategia.java` es por ahora una clase abstracta vacía. El usuario indicó que todavía no implementó las estrategias; no revisarlas como si estuvieran terminadas.
- Continuar con estrategias, servicios del local, copias filtradas y los tipos adicionales cuando el usuario los presente.
- Al finalizar, revisar comportamiento y casos límite contra todo el enunciado; compilar por sí solo no demuestra que la solución apruebe.
