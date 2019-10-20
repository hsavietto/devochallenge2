# Devo Challenge 2

* Description

Write an efficient algorithm to find K-complementary pairs in a given array of integers.
Given Array A, pair (i, j) is K-complementary if K = A[i] + A[j];

* Implementation notes

Pairs can be either ordered or unordered. Since the challenge doesn't specify which type of pair to use,
I opted for unordered pair (i.e. (1, 2) == (2, 1)). For this exercise it will avoid useless repetitions
in the result since the operation (addition) is commutative. If the code should be changed to accepts
different operations and those operations can be no commutative, it should be changed to use ordered pairs.

* Build instructions

At the root of the project directory, execute the command "mvn clean package". The executable jar will be
created at the "target" directory.

* Running the demo

To run the demo, execute the command "java -jar <jar_file_name> at the directory where the generated jar
file is.

* Complexity analysis

The time complexity of the main loop is O(n), because it relies on a map with the complementary positions
for each given value. Although the modern implementations of HashMap have an official worst case scenario
complexity of O(log(n)) in case of a high collision rate, this map uses Integer as key and since the
hashcode of an Integer is itself, this is a guaranteed collision-free scenario.

The preparation of this lookup map is also O(n), because it's executed for each item in the array and
HashMap and ArrayList insertion (in case of repeated complementaries) are both O(1), thus keeping the
preparation at O(n).

This way the final complexity for this K-complementary implementation is O(n).

