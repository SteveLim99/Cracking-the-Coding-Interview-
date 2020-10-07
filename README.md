# Cracking-the-Coding-Interview


## Solving Technical Questions Guide 

### 3. Optimize & Solve Techniques: BUD
- B - Bottlenecks 
- U - Unnecessary Work
- D - Duplicated Work 

A useful approach for optimizing algorithms. These 3 aspects are the most common thing an algorithm can waste time doing.
    
    Walk through brute force algorithm looking for these things and fix them
    
##### Bottlenecks 
 Definition:
    
    Part of algorithn that slows down overall runtime.
  
 Two common ways this occur:
 
 - One time work that slows down algorithm
    - I.E. Two step algorithm in which part 1 has TC of O(N log N) and part 2 has TC of O(N). Say, we can reduce TC of step 2 to O(1), this does not really matter as part 1 is the bottleneck.
 - Chunk of work that is being done repeatedly 
    - I.E. Searching in a list. Perhaps we can reduce the search TC from O(N) to O(N log N) or even O(1), greatly increasing runtime 
    