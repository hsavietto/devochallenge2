# Devo Challenge 2

* Description

Write an efficient algorithm to find K-complementary pairs in a given array of integers.
Given Array A, pair (i, j) is K-complementary if K = A[i] + A[j];

* Implementation notes

Pairs can be either ordered or unordered. Since the challenge doesn't specify which type of pair to use,
I opted for unordered pair (i.e. (1, 2) == (2, 1)). For this exercise it will avoid useless repetitions
in the result since the operation (addition) is commutative. If the code should be changed to accepts
different operations and those operations can be no commutative, it should be changed to use ordered pairs.



