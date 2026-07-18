#!/bin/bash
# Git Hands-On Lab - Question 2: .gitignore
# Execute these commands step by step

echo "=== Step 1: Create .gitignore ==="
cat > .gitignore << 'EOF'
*.log
log/
EOF

echo ""
echo "=== Step 2: Stage .gitignore ==="
git add .gitignore
git commit -m "Added .gitignore to ignore .log files and log folders"

echo ""
echo "=== Step 3: Create test files ==="
mkdir log
echo "sample log" > log/error.log
echo "debug info" > debug.log
echo "test run" > test.log
echo "important file" > readme.txt

echo ""
echo "=== Step 4: Check ignored files ==="
git status
echo ""
echo "Only readme.txt should appear - .log files and log/ are ignored"
