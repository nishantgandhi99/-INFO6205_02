# INFO6205 End Semester Project on Genetic Algorithm
Genetic Algorithms were invented to mimic some of the processes observed in natural evolution. Many people, biologists included, are astonished that life at the level of complexity that we observe could have evolved in the relatively short time suggested by the fossil record. The idea with GA is to use this power of evolution to solve optimization problems. The father of the original Genetic Algorithm was John Holland who invented it in the early 1970's

There is no rigorous definition of "genetic algorithm" accepted by all in the evolutionary−computation community that differentiates GAs from other evolutionary computation methods.
However, it can be said that most methods called "GAs" have at least the following elements in common:
populations of chromosomes, selection according to fitness, crossover to produce new offspring, and random
mutation of new offspring.

## Decision Problem: Given a graph G and an integer number k, is there a valid coloring with at most k colors?? (NP-Complete)
Given a graph G and a number k, decide whether G is k-colorable.
The k-coloring problem of a graph is NP-complete for every k >= 3.

    Special Cases:
    1. Polynomial for perfect graphs.
    2. NP-complete for planar graphs, even for planar 4-regular graphs.
    3. NP-complete for triangle-free graphs (even for k = 3).


#### Basic Definitions:

**Graph:** A graph G consist of finite set V and
an irreflexive binary relation on V. The set V is called *vertices*
and binary relation set is called *edges*.

**Irreflexive Property:** v is not R(v); for (v &epsilon; V).
i.e. The ralation is irreflexive if there is no relation (v,v) exist for all (v &epsilon; V).

**Stable Set:** A stable set is a subset X of vertices such that no two of which are adjacent. It is also called *Independent Set*.

**Proper K-coloring**: A proper *k-coloring* is a partition of the vertices
V = X1 + X2 + ... + Xk such that each Xi is stable set. In such case, the member of Xi are *painted* with color *i*
and adjacencey vertices will receive different color.

#### References:
1. Martin Charles Golumbic and Werner Rheinboldt, *Algorithmic Graph Theory and Perfect Graphs*, ISBN: 978-0-12-289260-8
2. Melanie Mitchell, *An introduction to Genetic Algorithms*, MIT press
3. "Genetic Algorithms" https://www.doc.ic.ac.uk/~nd/surprise_96/journal/vol1/hmw/article1.html