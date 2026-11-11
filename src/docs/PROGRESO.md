# Prefinal Tandil 25/11/2025 — progreso

Enunciado: `Prefinal 2025 - Tandil.pdf` (una página). Estamos en la etapa inicial de diseño. El usuario continuará escribiendo su propuesta completa antes de seguir con la revisión.

## Propuesta trabajada hasta ahora

- `Local` tiene un nombre y una lista de `Elemento` (relación de composición; `Elemento` no extiende `Local`).
- `Elemento` es la abstracción padre de `ProductoSimple` y `Combo`. Se propuso ubicar allí `id` y `marca`, con `getMarca()`, y declarar las operaciones comunes `getPrecio()` y `getCaracteristicas()` para que cada subtipo las resuelva.
- `ProductoSimple` tiene precio de lista y características propias.
- `Combo` contiene una lista de `Elemento` y calcula precio y características a partir de sus componentes.
- Se propuso `Combo.agregarElemento(Elemento)` como lugar para validar que el elemento agregado tenga la misma marca que el combo.

## Pendiente

- El usuario aún no terminó de presentar el diseño completo. No adelantar la solución ni implementar por él.
- Revisar cómo compara las marcas en Java y cómo distribuye las demás responsabilidades del enunciado cuando comparta su propuesta.
- Más adelante, examinar si `Pack` comparte comportamiento con `Combo` y cómo modelar las estrategias de promoción y la copia filtrada.
