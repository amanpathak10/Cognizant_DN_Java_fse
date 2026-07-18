# Question 1 - Git Setup & Basics

## Objectives
- Git configuration (user.name, user.email)
- Repository initialization (git init)
- File tracking (git add, git commit)
- Status and history (git status, git log)

## Repository: GitDemo
The repository contains:
- `welcome.txt` - tracked file with git history

## Commands Executed
```bash
git config user.name "Cognizant Learner"
git config user.email "learner@cognizant.com"
git init GitDemo
echo "Welcome to Git training" > welcome.txt
git add welcome.txt
git commit -m "Initial commit"
git log --oneline
```

## Git Log
