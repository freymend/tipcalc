# TipCalc

I want an app that knows how to calculate the tip on a dinner at a nice restaurant

Package it as `edu.uw.ischool.{yourNetID}.tipcalc`

## Stories

- As a user, when I launch the application, I should see a text edit (labled `Amount`) allowing me to enter the service charge, and a push button labled `Tip`. The `Tip` push button should be disabled.
- As a user, when I enter data into the service charge text edit, only numbers should be allowed.
- As a user, when I enter data into the service charge text edit, it should read like a USD currency amount `$15.23`; two decimal places, and prefixed by `$`.
- As a user, when I enter data into the service charge text edit, it should enable the `Tip` push button.
- As a user, when I push the `Tip` push button, it shold calculate the tip (15% of the value in the service charge text edit) and display that value in a Toast message. The value display should be displayed as USD currency `$15.23`): two decimal places, prefixed by `$`.

## Grading

5 pts, 1 per story

- repo should be called `tipcalc`
- repo should contain all necessary build artifacts
- include a directory called `screenshots` w/screenshot of app running on emulator

### Extra Credit (2 pts)

- add a spinner or some other control to choose the tip amount: 10%, 15%, 18%, or 20% and calculate accordingly (1 pt)
- make sure that only two decimal points ever appear, and that the math is always correct (1 pt)
