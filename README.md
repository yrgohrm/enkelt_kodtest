# Enkelt kodtest

Detta är ett enkelt kodtest för att pröva sin förmåga att lösa problem. Försök
lösa denna uppgift utan att använda Google eller AI-assistenter för att hitta
lösningen.

## Uppgift

I klassen `WeightedRandom` finns ett skall som behöver fyllas i med en riktig
implementation.

Det klassen skall göra är att generera slumpmässiga objekt, men där varje objekt
har en vikt, dvs. slumpfunktionen skall inte generera alla objekt lika ofta.

Om vi har objekten A, B och C med vikterna 1, 2 och 3 skall alltså A i snitt
slumpas fram 1/6 av tiden, medan C skall slumpas fram i snitt 1/2 tiden (3/6).

För att testa om din implementation verkar fungera kan du köra `mvn test`.

## Extra utmaning

Lösningen kan göras på flera sätt och den allra enklaste lösningen är inte 
speciellt snabb om man har väldigt många objekt som kan genereras. Kan du
göra en lösning som t.ex. använder sig av binärsökning för att snabba upp
även när man har väldigt många objekt att välja mellan?
