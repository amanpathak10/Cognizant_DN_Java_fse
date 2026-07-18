#!/bin/bash
# Git Hands-On Lab - Question 1: Git Setup & Basics
# Execute these commands step by step

echo "=== Step 1: Git Configuration ==="
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
git config --list

echo ""
echo "=== Step 2: Initialize Repository ==="
git init GitDemo
cd GitDemo

echo ""
echo "=== Step 3: Check Status ==="
git status

echo ""
echo "=== Step 4: Create and Track File ==="
echo "Welcome to Git training" > welcome.txt
git status
git add welcome.txt
git status
git commit -m "Initial commit: added welcome.txt"

echo ""
echo "=== Step 5: Modify and Commit ==="
echo "Hello Git World!" >> welcome.txt
git add welcome.txt
git commit -m "Updated welcome.txt"

echo ""
echo "=== Step 6: View History ==="
git log --oneline
