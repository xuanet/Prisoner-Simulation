# Prisoner-Simulation
100 Prisoner Problem Simulation
## Overview
A prison warden has prepared boxes and slips of paper indexed from 1 - 100. Each of the 100 slips of paper are randomly 
put into a box, with each box containing one slip of paper at the end of this process. 100 prisoners are tasked to form a 
strategy so that each prisoner can find the box containing their corresponding paper slip by opening 50 or fewer boxes.
They are considered successful only if all 100 prisoners find their corresponding paper slip. More on Wikipedia: https://en.wikipedia.org/wiki/100_prisoners_problem

### Strategy
If all prisoners randomly open 50 boxes, the probability that every prisoner will find their corresponding number is (0.5)^100, which
is an astronomically small number. By using the chaining strategy, their odds increase to above 30%.

### Simulation
This program simulates the puzzle. With many trials simulated, it does converge to the theoretical success rate of 31.183%.
