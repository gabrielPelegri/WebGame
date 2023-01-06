---
description: Aquí veremos la lógica del juego y sus partes más señaladas
---

# Cómo lo hemos construido

Para empezar tuvimos que distinguir las diferentes clases que necesitábamos implementar y ver como componerlas para que encajaran todas del mejor modo y más Adecuado para su operatividad.

Ahora podremos ver una breve explicación de las clases, en las cuáles explicaremos su función principal para el desarrollo del juego.

Además del transfondo de la concurrencia y cómo hemos usado los hilos y semáforos en el proyecto.

## CLASES

### CARD

Definimos la clase 'Card', como representación de una carta jugable. Incluye todas y cada una de sus características y atributos.

Aquí podemos ver una fragmento de sus atributos principales:

//insertar código//

Una de sus funciones más importantes se recoge en este método:

//insertar código//

### PLAYER

Definimos a la clase 'Player', como representación de un usuario de nuestro juego, ya registrado. Incluye todas y cada una de sus características y atributos, como su nombre de usuario, vida o mano de cartas para realizar sus jugadas.

Aquí podemos ver una fragmento de sus atributos principales:

//insertar código//

Una de sus funciones más importantes se recoge en este método:

//insertar código//

### GAME

Definimos a la clase 'Game', para representar una partida con su escenario de juego que corresponde. Cada partida es independiente. Aquí vemos como incluiremos los mazos de las cartas los jugadores participantes y el motor del juego.&#x20;

Podemos distinguir las clases que realizan la acción de elegir una carta, el ataque de dicha carta o la mano del jugador.

## CONCURRENCIA

### HILOS y SEMÁFOROS

Nos sirven para gestionar cómo funcionan los turnos que tendrán nuestros jugadores. Cada jugador constará de un hilo el cuál tendrá libre flujo de juego mientras sea su turno que terminará al cambio del semáforo, para dejar jugar al sus cartas al otro jugador.

De este modo controlaremos que cada jugador no interfiera en el turno del otro y exista una superposición de los hilos.
