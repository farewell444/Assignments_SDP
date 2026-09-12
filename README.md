# Assignment 1: Builder Design Pattern


## 1. Overview

This project demonstrates the implementation of the **Builder creational design pattern** in Java.

The chosen domain is a **Pizza Ordering System**. The Builder pattern was applied to avoid telescoping constructors and mutable state. It cleanly separates the construction steps of a complex `Pizza` object from its internal representation, allowing the creation of multiple distinct pizza styles using the same building process.

---

## 2. Architecture & Pattern Components

The implementation follows the classic GoF Builder architecture:

| Component | File | Responsibility |
|---|---|---|
| Product | `Pizza.java` | Immutable result object: `dough`, `sauce`, `topping`, `extraCheese` (all `final`) |
| Builder Interface | `PizzaBuilder.java` | Declares `setDough`, `setSauce`, `setTopping`, `setExtraCheese`, `reset`, `build()`; setters return `PizzaBuilder` for fluent chaining |
| Concrete Builder | `ItalianPizzaBuilder.java` | Neapolitan style: thin crust, tomato-basil sauce, mozzarella, no extra cheese |
| Concrete Builder | `AmericanPizzaBuilder.java` | American style: thick pan crust, BBQ sauce, cheddar/pepperoni/bacon, extra cheese enabled |
| Director | `PizzaDirector.java` | Encapsulates preset recipes: `makeClassicPizza`, `makePartyPizza` |
| Client | `Main.java` | Demonstrates Director presets and direct manual configuration |

---

## 3. How to Build Each Representation

### A. Classic Pizza via Director (Italian Style)

```java
PizzaDirector director = new PizzaDirector();
PizzaBuilder italianBuilder = new ItalianPizzaBuilder();

Pizza margherita = director.makeClassicPizza(italianBuilder);
```

### B. Party Pizza via Director (American Style)

```java
PizzaDirector director = new PizzaDirector();
PizzaBuilder americanBuilder = new AmericanPizzaBuilder();

Pizza partyPizza = director.makePartyPizza(americanBuilder);
```

### C. Custom Pizza via Direct Fluent API (No Director)

```java
Pizza customPizza = new ItalianPizzaBuilder()
        .setDough("Gluten-free crust")
        .setSauce("Pesto")
        .setTopping("Olives and Mushrooms")
        .setExtraCheese(true)
        .build();
```

---

## 4. Clean Code Principles Applied

1. **Meaningful Names** — descriptive domain terms (`dough`, `sauce`, `topping`), no cryptic abbreviations.
2. **Single Responsibility** — each setter performs one assignment and returns `this`.
3. **Validated Construction** — `build()` checks required fields and throws `IllegalStateException` on missing components.
4. **Immutability** — `Pizza` fields are `final`; no public setters on the product itself.
5. **Fluent API** — eliminates boilerplate, enables readable method chaining.

---

## 5. How to Run

### Prerequisites

- JDK 17 or higher
- IntelliJ IDEA (recommended) or terminal

### Execution via IntelliJ IDEA

1. Open the project directory in IntelliJ IDEA.
2. Set Project SDK to Java 17 (`File` → `Project Structure` → `Project`).
3. Navigate to `src/assignment1_builder/Main.java`.
4. Run via the green **Run** arrow or `Shift + F10`.
