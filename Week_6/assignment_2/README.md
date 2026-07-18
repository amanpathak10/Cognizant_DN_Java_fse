# Question 2 - Git Ignore

## Objectives
- Using .gitignore to ignore unwanted files and folders

## .gitignore Rules
```
*.log     # Ignore all files with .log extension
log/      # Ignore entire log/ directory
```

## Verification
- `debug.log`, `test.log`, and `log/error.log` are ignored
- `readme.txt` is the only file tracked
