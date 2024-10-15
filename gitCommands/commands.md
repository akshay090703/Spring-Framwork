1. git status
   status of the git repository
2. git init
   initializing the repository in the current directory
3. git init -b main
   the initial branch name is set to "main"
4. git add <file name>
   used to stage a file to git
5. git restore --staged <file>
   used to unstage a file from git
6. git log
   to get the history of the repository
7. git commit -m <"commit_message">
   commits the changes of the repo and add the commit message
8. git restore <file>
   to discard changes in working directory
9. git commit -a -m "commit_message"
   this "-a" skips the staging step
10. git diff --stage
    to see the changes between the different commits
    "--stage" is to see changes between the staged changes and last commit
11. git add .
    add on the files to the staging area in the directory
12. git rm --cached commands.md
    used to remove a particular file from the git directory and now you can remove it from your working environment too
13. git clone <address of the repo>
    clones the repository from the github
14. echo "# git-tutorial-demo" >> README.md
    push the text into a file and create a file if not there
15. git push -u origin main
    used to push the file from local copy to the remote copy
16. git remote add origin "git ssh or https link"
    used to connect the local environment to the github repo environment
17. git remote -v
    to see which os the origin, for fetch and push
