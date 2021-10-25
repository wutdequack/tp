# User Guide

## Introduction

{Give a product intro}

- [Duke User Guide](#duke-user-guide)
    - [Quick Start](#Quick Start)
    - [Features](#Features)
        - [Adding a todo : `todo`](#adding-a-todo--todo)
        - [Adding an elderly : `addelderly`](#adding-an-elderly-addelderly)
        - [Adding a medicine to an elderly : `addmed`](#adding-medicine-to-an-elderly-addmed)
        - [Adding an appointment to an elderly : `addappt`](#adding-appointment-to-an-elderly-addappt)
        - [Viewing medicine of an elderly : `viewmed`](#viewing-medicine-of-an-elderly-viewmed)
        - [Viewing appointments of an elderly : `viewappt`](#viewing-appointments-of-an-elderly-viewappt)
    - [Table of commands](#Command Summary)
    - [Reference](#reference)

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `Duke` from [here](http://link.to/duke).
3. Copy Duke.jar to the target directory as the home folder
4. Open terminal and move current directory to the home folder
5. Run the program using `java -jar Duke.jar` command.
6. We are all done. Type your first command in terminal to talk to Duke.

## Features 

{Give detailed description of each feature}

### Adding an elderly: `addelderly`
Adds an elderly to take care of. Risk level of elderly will be asked for, followed by additional
information if needed (according to risk level)

Format: `addelderly u/USERNAME n/NAME`

* The `USERNAME` only can contain characters or numbers.
* The `NAME` only can contain characters or whitespaces.

Example of usage:

` addelderly u/johntan123 n/John Tan`

```
> addelderly u/johntan123 n/John Tan
Enter risk level. (i.e. l for low, m for med, h for high.)
> h
List of hospitals are shown below:
1.changi general hospital
2.khoo teck puat hospital
3.national university hospital
4.ng teng feng general hospital
5.singapore general hospital
6.tan tock seng hospital
Enter hospital number choice. (e.g. 1 for Changi General Hospital etc.)
> 2
Enter elderly condition below. Hit enter when done.
> amnesia, stage 2 liver cancer, lower body paralysis
Enter notes on care below. Hit enter when done.
> at least 3 nurses required to ensure safety when showering. needs daily routine of going on walks at 7am. remember to lock wheelchair when stationary. meals should only be given during mealtimes to prevent overconsumption. reduce salt in food. liver checks to be done every sunday 3pm.
List of khoo teck puat hospital doctors are shown below:
1.adrian vergil
2.joline dean
3.shui lorin
4.britney soh
5.aditi nitya
Enter doctor number choice. (e.g. 1)
> 1
```

### Adding medicine to an elderly: `addmed`
Adds a medicine to an existing elderly.

Format: `addmed n/USERNAME m/MEDICINE_NAME f/FREQUENCY`

* The `USERNAME`  only can contain characters or numbers.
* The `MEDICINE_NAME` cannot contain punctuation.
* The `FREQUENCY` can be in a natural language format.

Example of usage:

`addmed n/johntan123 m/paracetamol f/once a day`

### Adding appointment to an elderly: `addappt`
Adds an appointment to an existing elderly.

Format: `addappt n/USERNAME l/LOCATION d/DATE t/TIME [p/PURPOSE]`

* The `USERNAME`  only can contain characters or numbers.
* The `LOCATION` can be in a natural language format.
* The `DATE` only can contain 8 numbers, in the format DDMMYYYY.
* The `TIME` only can contain 4 numbers, in the format hhmm.
* The `PURPOSE` can be in a natural language format.

Example of usage:

`addappt n/johntan123 l/khoo teck puat hospital d/02012021 t/1000`
`addappt n/johntan123 l/khoo teck puat hospital d/05032021 t/1500 p/eye checkup`

### Viewing medicine of an elderly: `viewmed`
Views all medicine of an existing elderly.

Format: `viewmed n/USERNAME`

* The `USERNAME`  only can contain characters or numbers.

Example of usage:

`viewmed n/johntan123`

### Viewing appointments of an elderly: `viewappt`
Views all appointments of an existing elderly.

Format: `viewappt n/USERNAME`

* The `USERNAME`  only can contain characters or numbers.

Example of usage:

### Terminating: `bye`
Terminates the current session.

Format: `bye`

Example of usage:

`bye`

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: AddMed does not seem to work? 

**A**: Our program is created for a fast user. Hence, we made the assumption that the user will only
type in small letters instead of capitalising some words. Use addmed instead.

**Q**: How do I add new hospitals and doctors?

**A**: Our program is created to keep track of elderly records, not to add hospitals and doctors.
Hence, we have made the hospitals and doctors fixed for this program, with the assumption that only
these few hospitals and doctors are available to be selected. 

Of course, you are welcome to upgrade this to make it more scalable! :D

## Command Summary

{Give a 'cheat sheet' of commands here}

|Command|Format|
|---|---|
|Add elderly |`addelderly u/USERNAME n/NAME`|
|Add medicine |`addmed n/USERNAME m/MEDICINE_NAME f/FREQUENCY`|
|Add appointment |`addappt n/USERNAME l/LOCATION d/DATE t/TIME [p/PURPOSE]`|
|View medicine |`viewmed n/USERNAME`|
|View appointment |`viewappt n/USERNAME`|

## Reference
The template of the User Guide is followed by [AddressBook Level 3 (AB3) User Guide](https://se-education.org/addressbook-level3/UserGuide.html#editing-a-person--edit).
