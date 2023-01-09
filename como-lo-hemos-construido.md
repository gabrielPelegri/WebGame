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
    private CardModel cardModelObjetivo;
```

Una de sus funciones más importantes se recoge en este método:

<pre class="language-java"><code class="lang-java">    public String getName() {
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

```java
    public PlayerModel(String name, Long health, ArrayList<CardModel> hand, ArrayList<CardModel> deck) {
        this.name = name;
        this.health = health;
        this.hand = hand;
        this.deck = deck;
    }

    public PlayerModel(UserModel userModel) {
        this.name = userModel.getName();
        this.health = 100L;
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
    }

    public PlayerModel(){
        this.name = "IA";
        this.health = 100L;
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
    }

    public void drawCard() {
        // Check if the player has any cards left in their deck
        if (deck.isEmpty()) {
            // The player's deck is empty, so they cannot draw a card
            System.out.println("No te quedan cartas en el mazo!");
        } else {
            // Draw a card from the top of the player's deck
            CardModel card = deck.remove(0);

            // Add the drawn card to the player's hand
            hand.add(card);

            // Print a message indicating that the card was drawn
            System.out.println("Ha sacado la carta: " + card.getName());
        }
    }

    // Method to play a card from the player's hand
    public void playCard(CardModel card) {
        // Check if the player has the specified card in their hand
        if (this.getHand().contains(card)) {
            // The player does not have the specified card in their hand
            System.out.println("No tienes esa carta en la mano!");
        } else {
            // Remove the card from the player's hand and play it
            this.getHand().remove(card);
            System.out.println("Ha jugado la carta: " + card.getName());
        }
    }


    // Method to attack with a card
    public void attackWithCard(CardModel card, CardModel target) {
        // Check if the player has the specified card in their hand
        if (this.getHand().contains(card)) {
            // The player does not have the specified card in their hand
            System.out.println("No tienes esa carta en la mano!");
        } else {
            // Remove the card from the player's hand and attack with it
            this.getHand().remove(card);
            target.setHealth(target.getHealth() - card.getDamage());
            System.out.println("Atacó con la carta: " + card.getName());
        }
    }

    public String getName() {
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

    public List<CardModel> getHand() {
        return hand;
    }

    public void setHand(ArrayList<CardModel> hand) {
        this.hand = hand;
    }

    public List<CardModel> getDeck() {
        return deck;
    }

    public void setDeck(List<CardModel> deck) {
        this.deck = deck;
    }

```

### GAME

Definimos a la clase 'Game', para representar una partida con su escenario de juego que corresponde. Cada partida es independiente. Aquí vemos como incluiremos los mazos de las cartas los jugadores participantes y el motor del juego.&#x20;

Podemos distinguir las clases que realizan la acción de elegir una carta, el ataque de dicha carta o la mano del jugador.

Aquí podemos ver una fragmento de sus atributos principales:

<pre class="language-java"><code class="lang-java"><strong>    private ArrayList&#x3C;PlayerModel> players;
</strong>    private int turnNumber;
    private Semaphore semaphore;
</code></pre>

Una de sus funciones más importantes se recoge en este método:

```java
public GameModel(ArrayList<PlayerModel> players) {
    this.players = players;
    this.turnNumber = 0;
    this.semaphore = new Semaphore(1);
}

public int jugadorObjetivo(int turnNumber) {
    int jugadorObjetivo = 0;
    if (turnNumber % 2 == 0) {
        jugadorObjetivo = 1;
    } else {
        jugadorObjetivo = 0;
    }
    return jugadorObjetivo;
}

// Method to start the game loop
public void run() throws InterruptedException {
    // Start the game loop
    boolean gameOver = false;
    while (!gameOver) {
        // Acquire the semaphore to take control of the game
        semaphore.acquire();

        // Get the current player
        PlayerModel currentPlayer = players.get(jugadorObjetivo(turnNumber-1));


        // Prompt the current player to take their turn
        System.out.println(currentPlayer.getName() + ", es tu turno!");

        // Handle the current player's actions
        handleTurn(currentPlayer);

        // Increment the turn number
        turnNumber++;

        // Release the semaphore to allow the next player to take their turn
        semaphore.release();
        if (currentPlayer.getHealth() <= 0 || currentPlayer.getDeck().isEmpty()) {
            gameOver = true;
            System.out.println("El jugador " + currentPlayer.getName() + " ha perdido");
        }
    }
}

// Method to handle a player's turn
public void handleTurn(PlayerModel player) {
    // Prompt the player to take their actions
    System.out.println("¿Qué quieres hacer: (1) Sacar una carta del mazo (2) Jugar una carta (3) Atacar con una carta");

    // Read the player's input and handle the appropriate action
    int action = readInput();
    if (action == 1) {
        player.drawCard();
    } else if (action == 2) {
        // Prompt the player to select a card to play
        System.out.println("Elije qué carta jugar: ");
        for (int i = 0; i < player.getHand().size(); i++) {
            System.out.println("(" + (i) + ") " + player.getHand().get(i).getName());
        }
        int cardIndex = readInput();
        CardModel card = player.getHand().get(cardIndex);
        player.playCard(card);
    } else if (action == 3) {
        // Prompt the player to select a card to attack with and a target player
        System.out.println("Elije una carta con la que atacar: ");
        for (int i = 0; i < player.getHand().size(); i++) {
            System.out.println("(" + (i) + ") " + player.getHand().get(i).getName());
        }
        int cardIndex = readInput();
        CardModel card = player.getHand().get(cardIndex);
        System.out.println("Elije qué carta atacar: ");
        for (int i = 0; i < players.get(jugadorObjetivo(turnNumber)).getHand().size(); i++) {
            System.out.println("(" + (i) + ") " + players.get(jugadorObjetivo(turnNumber)).getHand().get(i).getName());
        }
        int targetIndex = readInput();
        // PlayerModel target = players.get(targetIndex);
        player.attackWithCard(card, players.get(jugadorObjetivo(turnNumber)).getHand().get(targetIndex));
        // System.out.println("El jugador" + jugadorObjetivo(turnNumber) + "ha perdido " + card.getDamage() + "puntos de vida");
        System.out.println("La carta " + card.getName() + " ha atacado a la carta " + players.get(jugadorObjetivo(turnNumber)).getHand().get(targetIndex).getName());
        for (int i = 0; i < players.get(jugadorObjetivo(turnNumber)).getHand().size(); i++) {
            if (players.get(jugadorObjetivo(turnNumber)).getHand().get(i).getHealth() <= 0L) {
                System.out.println("La carta " + players.get(jugadorObjetivo(turnNumber)).getHand().get(i).getName() + " ha muerto");
                players.get(jugadorObjetivo(turnNumber)).getHand().remove(i);
                players.get(jugadorObjetivo(turnNumber)).setHealth(players.get(jugadorObjetivo(turnNumber)).getHealth() - 10L);
            }
        }
    }
}


// Method to read input from the console
public int readInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
}
```

## CONCURRENCIA

### HILOS y SEMÁFOROS

Nos sirven para gestionar cómo funcionan los turnos que tendrán nuestros jugadores. Cada jugador constará de un hilo el cuál tendrá libre flujo de juego mientras sea su turno que terminará al cambio del semáforo, para dejar jugar al sus cartas al otro jugador.

De este modo controlaremos que cada jugador no interfiera en el turno del otro y exista una superposición de los hilos.



## BASE DE DATOS

### MONGO DB

Para almacenar datos en la nube hemos utilizado la herramienta Mongo DB. A continuación se muestra el fragmento de código que hace posible la conexión entre la apliación y la base de datos.

```java
@Configuration
@EnableMongoRepositories(basePackages = "com.example.test.services")
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    protected String getDatabaseName() {
        return "GameDb";
    }

    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString("mongodb+srv://username:root@cluster0.thabl34.mongodb.net/?retryWrites=true&w=majority");
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.example.test");
    }
}

```

Como muestra el código, la aplicación conecta con la base de datos con nombre "GameDb", la cual cuenta con dos colecciones, una para los usuarios y otro para las cartas.

Es importante señalar que las clases UserModel y CardModel se utilizan como copia local de los datos guardados en la nube. Para ello hemos creado clases que convierten los usuarios y las cartas:&#x20;

```java
@Service
public class CardDataToCardModelConverter implements Converter<CardData, CardModel> {

    @Override
    public CardModel convert(CardData cardData) {
        CardModel cardModel = new CardModel();
        cardModel.setName(cardData.getName());
        cardModel.setHealth(cardData.getHealth());
        cardModel.setDamage(cardData.getDamage());
        return cardModel;
    }

}
```

```java
@Service
public class UserDataToUserModelConverter implements Converter<UserData, UserModel> {

    @Override
    public UserModel convert(UserData userData) {
        UserModel userModel = new UserModel();
        userModel.setId(userData.getId());
        userModel.setName(userData.getName());
        userModel.setAge(userData.getAge());
        userModel.setMail(userData.getMail());
        userModel.setPassword(userData.getPassword());
        userModel.setWins(userData.getWins());
        return userModel;
    }
}
```
