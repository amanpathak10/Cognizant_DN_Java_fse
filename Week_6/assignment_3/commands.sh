#!/bin/bash
# Git Hands-On Lab - Question 3: Branching & Merging

echo "=== Step 1: Create and switch to new branch ==="
git checkout -b GitNewBranch
echo "Branch feature content" > feature.txt
git add feature.txt
git commit -m "Added feature.txt on GitNewBranch"

echo ""
echo "=== Step 2: List branches ==="
git branch -a

echo ""
echo "=== Step 3: Switch to master and update ==="
git checkout main
echo "Updated main file" >> main.txt
git add main.txt
git commit -m "Updated main.txt on master"

echo ""
echo "=== Step 4: View differences ==="
git diff main..GitNewBranch

echo ""
echo "=== Step 5: Merge branch into master ==="
git merge GitNewBranch -m "Merged GitNewBranch into master"

echo ""
echo "=== Step 6: View merge log ==="
git log --oneline --graph --decorate

echo ""
echo "=== Step 7: Delete the branch ==="
git branch -d GitNewBranch
git branch -a
