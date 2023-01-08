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

Aquí podemos ver una fragmento de sus atributos principales: &#x20;

```java
    private String name;
    private Long health;
    private Long damage;
    private ArrayList<CardModel> status;

    final private int maxHealth = 100;
    private CardModel cardModelObjetivo;
```

Una de sus funciones más importantes se recoge en este método:

<pre class="language-java"><code class="lang-java">public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getDamage() {
        return damage;
    }

    public void setDamage(Long damage) {
        this.damage = damage;
    }

    public ArrayList&#x3C;CardModel> getStatus() {
        return status;
    }

    public void setStatus(ArrayList&#x3C;CardModel> status) {
        this.status = status;
    }

    public CardModel getCardModelObjetivo() {
        return cardModelObjetivo;
    }

    public void setCardModelObjetivo(CardModel cardModelObjetivo) {
        this.cardModelObjetivo = cardModelObjetivo;
    }
<strong>    public void combat(CardModel c) {
</strong>        long resta = this.health - c.damage;
        System.out.println(
                String.format(("La carta %s ha hecho %d a la carta %s"), this.name, resta, c.name));
    }
}
</code></pre>

### PLAYER

Definimos a la clase 'Player', como representación de un usuario de nuestro juego, ya registrado. Incluye todas y cada una de sus características y atributos, como su nombre de usuario, vida o mano de cartas para realizar sus jugadas.

Aquí podemos ver una fragmento de sus atributos principales:

<pre class="language-java"><code class="lang-java"><strong>    private String name;
</strong>    private Long health;
    private List&#x3C;CardModel> hand;
    private List&#x3C;CardModel> deck;
</code></pre>

Una de sus funciones más importantes se recoge en este método:

//insertar código//

### GAME

Definimos a la clase 'Game', para representar una partida con su escenario de juego que corresponde. Cada partida es independiente. Aquí vemos como incluiremos los mazos de las cartas los jugadores participantes y el motor del juego.&#x20;

Podemos distinguir las clases que realizan la acción de elegir una carta, el ataque de dicha carta o la mano del jugador.

Aquí podemos ver una fragmento de sus atributos principales:

//insertar código//

Una de sus funciones más importantes se recoge en este método:

//insertar código//

## CONCURRENCIA

### HILOS y SEMÁFOROS

Nos sirven para gestionar cómo funcionan los turnos que tendrán nuestros jugadores. Cada jugador constará de un hilo el cuál tendrá libre flujo de juego mientras sea su turno que terminará al cambio del semáforo, para dejar jugar al sus cartas al otro jugador.

De este modo controlaremos que cada jugador no interfiera en el turno del otro y exista una superposición de los hilos.
