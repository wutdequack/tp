# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Elderly risk categorisation
#### Implementation
The elderly risk categorisation is an addition to the current `Elderly` class. It utilises
**polymorphism**, creating three subclasses `LowRiskElderly`, `MediumRiskElderly`, `HighRiskElderly`,
all of which **inherits** from the `Elderly` class. <br>
Additionally, 2 new classes are implemented:
- `Hospital` — A class that contains information about a hospital, and contains a list of 
all its doctors. 
- `Doctor` — A class that contains information about a doctor

Below is a UML class diagram for the elderly risk categorisation:
![](team/img/elderly_implementation.png)


#### How the classes interact with each other

`LowRiskElderly`, `MediumRiskElderly` and `HighRiskElderly` are expected to contain all current 
attributes and methods that `Elderly` class is supposed to have. 

In addition, `MediumRiskElderly` and `HighRiskElderly` are tagged with extra information,
specifically `Hospital`, `Conditions` and `NotesOnCare`. `Conditions` is an array string that 
contains all the conditions the elderly has, while `NotesOnCare` is just a string that sequentially
lists tips to care for elderly. Each elderly here is tagged to 1 `Hospital`.

Finally, `HighRiskElderly` is also tagged with `Doctor`. Each elderly here is tagged to 1 `Doctor`.

Every `Hospital` has 1 or more `Doctor`, stored in an ArrayList of type `Doctor`. 

#### Design considerations

Since our TP is only intended for one user (i.e. the caretaker in the elderly home), the input of 
`Hospital` and `Doctor` data should not be done by them. As such, we have made it such that they are
preset. `Hospital` and `Doctor` data are made to be fixed, as we make the assumption that the
`Hospital` and `Doctor` that the `MediumRiskElderly` and `HighRiskElderly` are looking for 
are already there. 

### Autosuggestions for search functions
#### Problems Faced
For fast typers, they may **misspell words** and are somehow convinced that their spelling is correct. 
Furthermore, as our program mainly deals with usernames, medicine names, etc., they may be cryptic 
and **difficult to remember**. 

#### Solution to said problems
We opted to have an autosuggestion function that will look for the 
closest possible search result in the store of the program. 

#### Details of solution
We used a concept known as [Levenshtein Distance](https://medium.com/@ethannam/understanding-the-levenshtein-distance-equation-for-beginners-c4285a5604f0) 
to check the similarities between 2 strings. 

For brevity, I will attempt to explain the concept here. In essence, it checks what are the number 
of edits made at position `i` of 2 strings. This can be better illustrated with an example. 

Given that we have a medicine `panadol` in the system and a misspelt user query of `parasol`. 
Assuming we have `i` as the iterator for `panadol` and `j` as the iterator of `parasol`. At position
`i=3` and `j=3`, there is a change of 1 character from `n->r` so `lev_i,j(3,3) = 1` as 1 edit is 
required. At `lev_i,j(7,7)`, there would have been a total of 2 characters changed. 

![Image of Levenshtein Distance Function](team/img/lev_function_img.jpg)
<p align = center>Image of Levenshtein Distance Function</p>

The function above is applied to both strings and its results are compounded. We then take a **ratio 
of the number of unchanged characters over the total number of characters in both strings** to 
determine how similar the 2 strings are. 

#### How is it applied to the program?
When using the `findbymed`, `findbydiet`, `findbyname` functions, they will take generate a set of 
medicine, diets and real names respectively. The function `checkSimilarities` in `ElderlyList.class`
will then iterate through each item in the set and compare it with the query term. If there is a 
similarity score of `>=0.8`, the closest match will be printed. 

#### How did you determine that the magic similarity value to be used is 0.8?
It was through vigorous trial and testing that 0.8 seems like the most appropriate value. 

#### An example of AutoSuggestions
Assuming we have an elderly that exist in the system called `John Tan`. We, as the user, remember 
that his name was `<SOMETHING> Tan`, and it was either `Josh` or `John`. We try `Josh`
first.

![Example of AutoSuggestions](team/img/autosuggestions_example.png)

Instead of just prompting that the system could not find `Josh Tan`, the search term went through
the Levenshtein Distance logic and the name `John Tan` returned with a result of `0.9375`. As you 
can see, this was our intended result and showcases the intended solution to our problem.

#### Potential Shortcomings of this function
There may be two strings that have similar edit distance to each other but may not be related to 
each other. This will include words like `sitting` and `kitten` for example. This may give 
inaccurate suggestions. However, since this is **not a key function** and is only meant to be a 
complementary tool, **it will not be a major problem**.

## Product scope
Hi, welcome to the Elderly in Your Hood.
It is a product to empower service personnel to 
store information about the elderly they are servicing in the elderly home.

### Target user profile
It is for service staffs at the elderly home who works at a PC,
prefers typing, and wants to avoid the tedious tracking of details of each and every
elderly they are servicing.

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}
1. The product is not required to ensure that the dosage of medicine keyed are safe.
2. The product should work on both 32-bit and 64-bit system.

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
