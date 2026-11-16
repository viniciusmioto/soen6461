
# Composite

- Sorting algorithms
  - Internal
  - External
- Trees of objects
- Part-whole hierarchy 
- Hiding the differences for the client
- GUIs: AWT, Swing, etc
- Tree structures: AST

# Iterator
- Adds one level of indirection
- Give to the client an object that allows to iterate a list, and not the list itself
- Prevent the client to modify the list
- hasNext() and getNext()
- Race conditions (multi thread): co-modifications 
  - iterate and modify at the same time