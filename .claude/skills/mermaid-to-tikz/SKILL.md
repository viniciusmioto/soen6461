---
name: mermaid-to-tikz
description: Convert a Mermaid (or any auto-laid-out) class diagram in the course notes into a hand-positioned TikZ UML diagram, render it to PDF and JPEG in _notes/_images, and replace the Mermaid block in the note with the image. Use when the user asks to convert a mermaid diagram to TikZ/JPEG/image, or to make a diagram "like the others".
---

# Mermaid -> TikZ -> JPEG (course notes)

The user dislikes automatic layouts (Mermaid, PlantUML): classes end up badly positioned.
They want **manual, meaningful positioning** (hierarchy top-down, spacing, no crossings), rendered to JPEG and embedded in the note.

## Steps

1. **Read the Mermaid block** in the note (usually `_notes/Week XX - ... .md`). Identify classes, members, relations, multiplicities, notes.
2. **Copy `template.tex`** (next to this file) to `_notes/_images/<topic>_<name>.tex` (snake_case, e.g. `composite_filesystem.tex`). Keep its preamble and styles unchanged so every diagram looks the same.
3. **Lay out by hand** (coordinates in cm, y grows downwards as negative):
   - Client on top; the main interface/abstraction below it; implementations below that.
   - Interfaces/abstract types above their implementations; siblings on the same row.
   - Put each realization/generalization on **its own line** (no shared buses), straight vertical where possible.
   - Route long relations (aggregation back to the component, etc.) around the outside with `--` corner points.
   - Add the DP **role tags** in blue at each box's north-east corner (`\node[role] at (X.north east) {Leaf};`) when the diagram illustrates a design pattern.
   - Put a dashed `note` under the class whose behaviour matters (e.g. the Composite's loop over children).
4. **Render**:
   ```bash
   cd _notes/_images && pdflatex -interaction=nonstopmode <name>.tex | grep -E "^!|Output written"
   pdftoppm -jpeg -r 170 -singlefile <name>.pdf <name> && rm -f <name>.aux <name>.log
   ```
5. **Look at the JPEG** (Read tool) and fix anything unclear: labels inside boxes, labels on top of lines, role tags covering a line, arrows ending inside a box, crossing lines. Re-render until it is clean. Never report it done without viewing it.
6. **Replace the Mermaid block** in the note with `![<short description>](_images/<name>.jpg)` (path relative to the note). Keep the `.tex` and `.pdf` next to the `.jpg`.
7. Do not commit unless asked.

## UML conventions used (styles in template.tex)

| Relation | Style | Meaning |
|---|---|---|
| `real` | dashed, hollow triangle | realization (`implements`) |
| `gen` | solid, hollow triangle | generalization (`extends`) |
| `dep` | dashed, open arrow | dependency (uses / creates / returns) |
| `ass` | solid, open arrow | association (holds a reference / uses) |
| `agg` | hollow diamond at the whole | aggregation (whole o-- part), add multiplicity `0..*` near the part |

Object diagrams (e.g. a Mermaid `flowchart` showing a tree of instances): use UML object notation, `\underline{name : Class}` in bold, attribute values like `bytes = 10` in a second compartment, plain solid arrows for links, nodes of a row placed with `anchor=north` at the same y so rows align. Example: `_notes/_images/composite_filesystem_objects.tex`.

Boxes: `cls0` (name only), `cls` (name + one compartment), `cls3` (name + attributes + operations).
Header: `\hd{<<interface>>}{Name}` or `\hd{}{Name}`. Visibility `+ - \#`.

## Pitfalls already met (avoid them)

- `>>` in node text becomes a `»` ligature: write `>{}>` for generics like `List<ISort<E>{}>`; `<<interface>>` is fine.
- `-|` / `|-` with a literal coordinate like `(4,0)` uses y=0, not the node's y: anchor with `(x,0 |- Node.north)` or `(Node.east |- 0,y)`.
- `minimum height` is ignored on `rectangle split` nodes: to make a box taller, add content or a `\raisebox`.
- Multiplicity labels must sit **outside** the box edge (check the box's half-width: `text width/2 + inner xsep`).
- Inside `\foreach` lists, wrap items that contain commas in braces: `{dependency (uses, creates)}`.
- Do not name macros `\dp` (TeX primitive).
- Role tags have no fill: keep realization lines away from the box's north-east corner, or move the tag.
