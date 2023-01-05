---
description: >-
  Aquí veremos el estudio, análisis, organización, disposición y estructuración
  de la información además de la captura de requisitos para saber las funciones
  del juego.
---

# Diseño y Arquitectura

## REQUISITOS

1. Juego por turnos
2. Concurrencia (Uso de hilos y semáforos)
3. Cartas y Personajes
4. Web publicitaria del juego
5. Login y Register web
6. Login y Register in game
7. BBDD para almacenar el contenido y usuarios
8. Versión Móvil y Versión Escritorio
9. Docker file para el despliegue del juego
10. Documentación del proyecto detallada

Como veremos a continuación veremos brevemente los puntos de de los cuáles hemos cumplido&#x20;

### Juego por turnos

En principio nuestro juego se basa en las funcionalidades a un nivel más simple, que el famoso juego de cartas 'Hearthstone' o 'Magic Arena'.

<figure><img src="https://assets.reedpopcdn.com/hearthstone-is-coming-to-android-tablets-before-end-of-year-1413918068236.jpg/BROK/thumbnail/1600x900/quality/100/hearthstone-is-coming-to-android-tablets-before-end-of-year-1413918068236.jpg" alt=""><figcaption><p>Hearthstone</p></figcaption></figure>

<figure><img src="https://assets2.rockpapershotgun.com/prompts-remind-you-that-there-are-ways-to-do-mischief-even-on-your-opponents-turn.png/BROK/thumbnail/1600x800/format/jpg/quality/80/prompts-remind-you-that-there-are-ways-to-do-mischief-even-on-your-opponents-turn.png" alt=""><figcaption><p>Magic Arena</p></figcaption></figure>

Constamos de 2 jugadores los cuales tendrán una baraja cada uno  en la cuál puede jugar determinados tipos de carta en función a un palo o equipo(Spetnaz, SASS...)

También nuestro juego consta de 9 personajes relacionados con el CALL of DUTY, porque han aparecido en algunas de sus campañas de los famosos juegos de consola y PC. Como por ejemplo: Mason, Ghost, Soap o incluso Hot Capuchino (Fidel Castro).

Para poder ganar una partida el jugador puede :&#x20;

* [ ] Acabar con la vida del rival
* [ ] Dejar a su rival sin cartas

Una vez cumplida alguna de estas 2 tareas, se le dará la victoria al jugador ganador.

### Cartas y Personajes

Las cartas y personajes serán relacionadas con los juegos 'CALL of DUTY', y constarán de una series de funciones, habilidades y tributos para poder ganar en el juego.



