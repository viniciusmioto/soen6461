# SOEN 6461 — Practice Exercise: Design Patterns on a File System

**Patterns covered:** Composite · Iterator · Observer · Decorator
**Suggested time:** 3 hours  **Total:** 100 marks
**Allowed:** Java SE only (no external libraries). No IDE code generation for UML.

---

## General Context

You are designing the core of a small **in‑memory file system** library called `MiniFS`.

- Every item in the file system is an **Element**.
- An Element is either a **File** or a **Folder**.
- A **File** has a `name`, a `size` (in bytes), an `extension` and a `content` (String).
- A **Folder** has a `name` and can contain **any number of Elements** (Files and/or other Folders), at any depth.
- Every Element knows its **parent** folder (the root folder has no parent) and can compute its **full path** (e.g. `/root/docs/report.txt`).

Use the following tree in all client programs and tests unless stated otherwise:

```
root/
├── docs/
│   ├── report.txt      (1200 bytes)
│   ├── notes.md        (300 bytes)
│   └── archive/
│       └── old.txt     (5000 bytes)
├── images/
│   ├── cat.png         (20000 bytes)
│   └── dog.jpg         (18000 bytes)
├── empty/
└── readme.md           (150 bytes)
```

**General rules**

1. Each section has three parts: **(A) Design – UML class diagram**, **(B) Implementation – Java**, **(C) Questions**.
2. UML diagrams must show: classes/interfaces, stereotypes (`<<interface>>`, `<<abstract>>`), attributes and operations with visibility and types, and relationships with correct notation (generalization, realization, association, aggregation/composition, dependency) and multiplicities.
3. In every UML diagram, **identify the role** each class plays in the pattern (e.g. `Component`, `Leaf`, `Composite`, …) as a note or stereotype.
4. Code must respect: programming to interfaces, encapsulation (no public fields), and separation into packages `minifs.client`, `minifs.fs`, `minifs.fs.impl` (add sub‑packages per pattern if needed).
5. Each section builds on the previous one. If you could not finish a previous section, state your assumptions clearly.

---

## Section 1 — Composite (25 marks)

### 1.A Design (8 marks)

**Q1.1** Draw the UML class diagram of `MiniFS` applying the **Composite** pattern. It must include at least:
- an abstraction for `Element`,
- `File` and `Folder`,
- the operations: `getName()`, `getSize()`, `getPath()`, `getParent()`, `print(int indent)`, `add(Element)`, `remove(Element)`, `getChild(int)`, `getChildren()`.

**Q1.2** You must decide where `add/remove/getChild` are declared. Draw **two** variants of the key part of the diagram:
- (a) the **transparent** (uniformity) variant,
- (b) the **safe** (type‑safety) variant.

Indicate clearly which one you choose for the implementation.

**Q1.3** Add to your diagram an **object diagram** representing the `docs/` subtree of the General Context.

### 1.B Implementation (10 marks)

**Q1.4** Implement the design chosen in Q1.2 in Java.

**Q1.5** Implement the following behaviours:
- `getSize()` of a Folder returns the **total size** of everything it contains (recursively).
- `print(int indent)` prints the tree with indentation, folders suffixed with `/` and files with their size.
- `getPath()` returns the absolute path built from the parents.
- Adding an Element to a Folder must update the Element's parent. Adding an Element that already has a parent must **move** it (remove it from its old parent).
- Adding a Folder **into itself or into one of its descendants** must be rejected with an appropriate exception.
- Two children with the **same name** in the same folder must be rejected.

**Q1.6** Write a `Client` (`minifs.client`) that builds the General Context tree and prints:
1. the whole tree,
2. the size of `root`, `docs` and `empty`,
3. the path of `old.txt`,
4. the tree after moving `archive/` into `images/`.

**Q1.7** Explain (in code comments or a short text) how your client creates Elements. The client must **not** depend on concrete classes from `minifs.fs.impl` directly — provide a creation mechanism that respects this.

### 1.C Questions (7 marks)

**Q1.8** What problem does the Composite pattern solve here? What would the client code look like *without* it?

**Q1.9** Discuss the trade‑off between the transparent and safe variants in the context of a file system. What happens in each variant when the client calls `add()` on a File?

**Q1.10** Where should the reference to the parent be stored, and who is responsible for keeping it consistent? What can go wrong?

**Q1.11** Is the relationship between `Folder` and `Element` an aggregation or a composition? Justify with respect to what happens when a folder is deleted.

**Q1.12** Which SOLID principle(s) does your design respect or violate? Give one concrete example for each.

**Q1.13** A colleague proposes adding `instanceof Folder` checks inside `getSize()`. Explain why this is a design smell.

---

## Section 2 — Iterator (25 marks)

The client now needs to **traverse** the file system in different ways **without knowing** how a `Folder` stores its children (you are encouraged to change the internal collection, e.g. from `ArrayList` to an array or a `Map`, to prove it).

### 2.A Design (8 marks)

**Q2.1** Extend your UML diagram from Section 1 with the **Iterator** pattern. It must include:
- your own iterator interface (do **not** only reuse `java.util.Iterator`; you may make yours extend it if you justify it), with at least `hasNext()`, `next()`, and `reset()`,
- the **Aggregate** role (who creates iterators?),
- at least **three** concrete iterators:
  1. `DepthFirstIterator` (pre‑order),
  2. `BreadthFirstIterator` (level by level),
  3. `FilterIterator` that only returns Elements satisfying a criterion (e.g. extension = `.txt`, size > N, only folders).

**Q2.2** Mark the roles `Iterator`, `ConcreteIterator`, `Aggregate`, `ConcreteAggregate` on the diagram.

**Q2.3** Draw a **sequence diagram** of the client iterating over `docs/` with the `DepthFirstIterator`, until the second element is returned.

### 2.B Implementation (10 marks)

**Q2.4** Implement the three iterators. For `File`, what should `createIterator()` return? Implement your decision.

**Q2.5** Make `Element` (or `Folder`) usable in a Java *for‑each* loop: `for (Element e : root) { ... }`.

**Q2.6** In the client, using **only iterators** (no recursion in the client):
1. print all elements of `root` in depth‑first order,
2. print all elements of `root` in breadth‑first order,
3. print the path of every `.txt` file,
4. print every folder that is empty,
5. compute the total size of files larger than 1000 bytes.

**Q2.7** Specify and implement what happens when the tree is **modified during iteration** (e.g. a file is added to `docs/` while a depth‑first iteration is in progress). Choose a policy (fail‑fast, snapshot, or tolerate) and implement it.

### 2.C Questions (7 marks)

**Q2.8** What is the difference between an **internal** and an **external** iterator? Which kind did you implement? Give one advantage of the other kind.

**Q2.9** Why should the traversal algorithm live in the iterator and not in `Folder`? Which principle does that respect?

**Q2.10** Your `FilterIterator` could either *subclass* another iterator or *wrap* one. Which did you choose and why? Which other pattern from this exercise does the wrapping approach resemble?

**Q2.11** Explain the trade‑offs of your concurrent‑modification policy from Q2.7.

**Q2.12** How does Iterator collaborate with Composite? Could you implement a depth‑first iterator without a stack (explicit or via recursion)? Explain.

---

## Section 3 — Observer (25 marks)

`MiniFS` must now **notify** interested parties when the file system changes. Required observers:
- a **Logger** that prints every event (`CREATED`, `DELETED`, `MOVED`, `RENAMED`, `MODIFIED`) with the element's path,
- a **QuotaMonitor** that warns when a given folder exceeds a maximum size,
- a **SearchIndex** that keeps a `Map<String, List<String>>` from extension to paths, always up to date.

### 3.A Design (8 marks)

**Q3.1** Extend your UML diagram with the **Observer** pattern. Include:
- the `Subject` and `Observer` roles,
- an **event** class carrying the information about the change (type, source element, old/new values as needed),
- the three concrete observers above.

**Q3.2** Decide and show in the diagram **who is the subject**: each Element, each Folder, or a single central `FileSystem` object. Justify your choice in one paragraph.

**Q3.3** Draw a **sequence diagram** showing what happens when the client renames `notes.md` to `todo.md`, with the Logger and the SearchIndex registered.

### 3.B Implementation (10 marks)

**Q3.4** Implement the subject, the event class and the three observers. Do **not** use `java.util.Observer`/`Observable` (deprecated).

**Q3.5** Implement `rename(String)` and `setContent(String)` on File (content change updates the size).

**Q3.6** **Event propagation (bubbling):** an observer attached to `docs/` must be notified of changes happening in **any descendant** of `docs/` (e.g. modifying `archive/old.txt`), but not of changes in `images/`. Implement it.

**Q3.7** In the client:
1. register the Logger on `root`, the QuotaMonitor on `images/` (limit: 40000 bytes), and the SearchIndex on `root`,
2. add `bird.gif` (5000 bytes) to `images/`,
3. rename `notes.md` to `todo.md`,
4. delete `archive/`,
5. print the SearchIndex content,
6. detach the Logger and modify `report.txt` — nothing should be logged.

### 3.C Questions (7 marks)

**Q3.8** Push model vs. pull model: which one did you use? Show where in your code each model would differ.

**Q3.9** When `archive/` is deleted, should observers be notified once (for the folder) or once per element inside it? Discuss the consequences for the SearchIndex.

**Q3.10** What happens if an observer **modifies the file system** inside its `update()` method (e.g. the QuotaMonitor deletes the biggest file)? Identify the risks and propose a safeguard.

**Q3.11** Observers stored in a subject can cause **memory leaks**. Explain why and propose a solution.

**Q3.12** How does the Observer pattern reduce coupling between `minifs.fs` and the Logger/QuotaMonitor/SearchIndex? Which direction do the package dependencies go?

**Q3.13** Is the order in which observers are notified guaranteed? Should the client rely on it?

---

## Section 4 — Decorator (25 marks)

Files must now support **optional, combinable features** added at runtime, without modifying `File`:
- **Compression** — `getSize()` returns ~50% of the size; `read()` returns content prefixed with `[compressed]`.
- **Encryption** — `read()` returns the content reversed (simulated encryption) unless `decrypt(String key)` was called with the right key.
- **ReadOnly** — `write(String)` throws an exception.
- **Versioning** — every `write()` keeps the previous content; supports `undo()`.

### 4.A Design (8 marks)

**Q4.1** Extend your UML diagram with the **Decorator** pattern. Mark the roles `Component`, `ConcreteComponent`, `Decorator`, `ConcreteDecorator`. You may need to introduce a `FileElement`/`IFile` abstraction with `read()` and `write(String)`.

**Q4.2** Show clearly the **two** relationships between the abstract decorator and the component (hint: one *is‑a*, one *has‑a*) with multiplicities.

**Q4.3** Draw a **sequence diagram** of `read()` called on `new Encrypted(new Compressed(file))`.

### 4.B Implementation (10 marks)

**Q4.4** Implement the abstract decorator and the four concrete decorators.

**Q4.5** A decorated file must still be **insertable in a Folder** and still behave correctly with `getSize()`, iterators (Section 2), and observers (Section 3). Implement whatever is needed and demonstrate it.

**Q4.6** In the client:
1. make `report.txt` compressed and encrypted, add it to `docs/`, print `docs/` size before and after,
2. make `readme.md` read‑only and try to write to it (handle the exception),
3. make `notes.md` versioned, write three times, undo twice and print the content,
4. show that `new Compressed(new Encrypted(f))` and `new Encrypted(new Compressed(f))` produce different `read()` results.

**Q4.7** Implement a method that, given a decorated file, returns the **list of features** applied to it (e.g. `[Encrypted, Compressed]`). Do it without `instanceof` checks in the client.

### 4.C Questions (7 marks)

**Q4.8** Why use Decorator here instead of inheritance (`CompressedFile`, `EncryptedCompressedFile`, …)? Quantify the number of subclasses needed for 4 features with inheritance.

**Q4.9** Does the order of decorators matter? Give one example from your implementation where it does and one where it does not.

**Q4.10** What is the problem of **object identity** with decorators? What happens if you call `docs.remove(originalFile)` after adding its decorated version? How did you handle it?

**Q4.11** Should Folders be decoratable too (e.g. a `ReadOnly` folder)? Which changes in your design would that imply?

**Q4.12** Compare Decorator and Composite: both use recursive composition. What is the difference in **intent** and in **structure** (multiplicity of the contained component)?

**Q4.13** Compare Decorator with the wrapping `FilterIterator` (Q2.10). Is it a Decorator? Justify.

---

## Bonus — Integration (up to +10 marks)

**B1** Produce **one final UML class diagram** with all four patterns, with each class annotated with *all* the roles it plays (a single class may play several roles in different patterns).

**B2** Implement `find(Folder start, Predicate<Element> p)` that returns the matching elements using your iterators, then attach an observer that logs every file found with size > 10000 and compresses it with your decorator. Explain any issues with modifying the tree during this process.

**B3** In at most half a page: which of the four patterns had the biggest impact on the **extensibility** of `MiniFS`, and which one introduced the most **complexity**? Justify.

---

*End of exercise. Answers are intentionally not provided.*
