# SOEN 6461 — Practice Exercise (Minimal): Design Patterns on a File System

**Patterns:** Composite · Iterator · Observer · Decorator
**Target time:** 60–90 minutes  **Total:** 40 marks
**Focus:** the *patterns* (roles, relationships, intent). The file system is only a pretext — keep it dummy.

---

## Context

Everything is a **File System Item**. A File System Item is either a **File** (name + size) or a **Folder** (name + children). A Folder can contain Files and other Folders.

Tree to use in all clients:

```
root/
├── docs/
│   ├── a.txt   (10)
│   └── b.txt   (20)
├── img/
│   └── c.png   (30)
└── d.md        (5)
```

### Dummify rules (do NOT spend time on these)

- No real files, no I/O, no paths, no parent pointers, no validation, no exceptions unless asked.
- A file's "content" is just a `String`. Size is an `int` you pass to the constructor.
- `print()` can just be `System.out.println(name)` — indentation optional.
- Use `ArrayList` everywhere. Ignore thread safety and concurrent modification.
- Traversal algorithms are **given** below — copy them.
- Packages, as in the course examples: `client`, `fs` (interfaces), `fs.impl` (classes + `Factory`).

---

## Section 1 — Composite (10 marks, ~20 min)

**Q1.1 (UML, 4 marks)** Draw the class diagram with `IFileSystemItem`, `File`, `Folder` (an `AbstractFileSystemItem` is optional). Label the roles **Component / Leaf / Composite** and show the multiplicity of the Folder → FileSystemItem relationship.

**Q1.2 (Code, 4 marks)** Implement it. Required operations only:

```java
public interface IFileSystemItem {
    String getName();
    int getSize();      // Folder: sum of children
    void print();
}
```

> 💡 Hint: `Folder` holds a `List<IFileSystemItem> children` and exposes `add(IFileSystemItem)`. `getSize()` in Folder is a one‑line loop / stream over children — the recursion "just happens" because children are also `IFileSystemItem`.

> 💡 Hint: Mirror the course style — let the client create objects through `Factory.createFile(name, size)` / `Factory.createFolder(name)` so it only knows interfaces.

Client: build the tree, print it, and print `root.getSize()` (expected: `65`).

**Q1.3 (Question, 2 marks)** You declared `add()` either in `IFileSystemItem` (transparent) or only in `Folder` (safe). Which did you choose, and what is the one trade‑off?

---

## Section 2 — Iterator (10 marks, ~20 min)

Goal: the client traverses the tree without knowing that Folder uses a `List`.

**Q2.1 (UML, 4 marks)** Extend the diagram with `IFileSystemItemIterator`, one concrete iterator, and the factory method `createIterator()`. Label roles **Iterator / ConcreteIterator / Aggregate / ConcreteAggregate**.

```java
public interface IFileSystemItemIterator {
    boolean hasNext();
    IFileSystemItem next();
}
```

**Q2.2 (Code, 4 marks)** Implement `DepthFirstIterator` using the algorithm below (given — just wrap it in the pattern):

```java
// Given: pre-order DFS with an explicit stack
private final Deque<IFileSystemItem> stack = new ArrayDeque<>();

public DepthFirstIterator(IFileSystemItem start) { stack.push(start); }

public boolean hasNext() { return !stack.isEmpty(); }

public IFileSystemItem next() {
    IFileSystemItem current = stack.pop();
    if (current instanceof Folder f) {          // ok here: hidden inside the iterator
        List<IFileSystemItem> kids = f.getChildren();
        for (int i = kids.size() - 1; i >= 0; i--) stack.push(kids.get(i));
    }
    return current;
}
```

> 💡 Optional: a `BreadthFirstIterator` is the same code with a `Queue` (`offer`/`poll`) instead of a stack. Do it only if you have time.

Client: print every item's name using only the iterator (expected order: `root, docs, a.txt, b.txt, img, c.png, d.md`).

**Q2.3 (Question, 2 marks)** Why is it better to put the traversal in an iterator rather than in `Folder` or in the client? Name the principle.

---

## Section 3 — Observer (10 marks, ~20 min)

Goal: when a Folder gets a new child, interested parties are notified.

**Q3.1 (UML, 4 marks)** Extend the diagram with `ISubject` (attach/detach/notify), `IObserver`, and two concrete observers: `Logger` and `SizeWatcher`. Decide which class is the **ConcreteSubject**. Label all roles.

```java
public interface IObserver {
    void update(String event, IFileSystemItem source);   // push model, kept simple
}
```

> 💡 Hint: make `Folder` the subject. In `add()`: add the child, then `notifyObservers("ADDED", child)`. That's it — no event classes, no bubbling.

**Q3.2 (Code, 4 marks)** Implement it.
- `Logger` prints `"[LOG] ADDED x.txt"`.
- `SizeWatcher` prints a warning if the folder size exceeds a limit given in its constructor.

Client: attach both to `docs`, add `e.txt (50)`, then detach `Logger` and add `f.txt (1)`.

**Q3.3 (Question, 2 marks)** You used the push model. What would change with the pull model, and when would it be preferable?

---

## Section 4 — Decorator (10 marks, ~20 min)

Goal: add optional, combinable behaviour to files at runtime without modifying `File`.

**Q4.1 (UML, 4 marks)** Extend the diagram with `FileDecorator` (abstract) and two concrete decorators: `Compressed` and `ReadOnly`. Show **both** relationships between `FileDecorator` and `IFileSystemItem` (one *is‑a*, one *has‑a*). Label roles **Component / ConcreteComponent / Decorator / ConcreteDecorator**.

**Q4.2 (Code, 4 marks)** Implement it. Dummy behaviour is enough:

```java
// Compressed: getSize() returns wrapped.getSize() / 2
// ReadOnly:   getName() returns wrapped.getName() + " [RO]"
```

> 💡 Hint: the abstract decorator just delegates every `IFileSystemItem` method to `wrapped`; each concrete decorator overrides one method and calls `super`.

Client: create `big.bin (100)`, wrap it as `new ReadOnly(new Compressed(file))`, add it to `img`, then print `img.getSize()` and iterate over `img` (Section 2) to show the decorated name appears.

**Q4.3 (Question, 2 marks)** Decorator and Composite both wrap `IFileSystemItem`s recursively. What is the difference in **intent** and in **multiplicity**?

---

## Final check (no marks)

In one sentence each: which role(s) does `Folder` play across the four patterns? And `IFileSystemItem`?

---

*Answers intentionally not provided.*
