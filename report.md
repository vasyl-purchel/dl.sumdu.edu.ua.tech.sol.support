# First task.

| Subject | Value |
| ------- | ----- |
| Repository | https://github.com/vasyl-purchel/dl.sumdu.edu.ua.tech.sol.support |
| VCS | git |
| Hosting | github.com |

1. Create git repo on github.com and clone it locally:

```
$ git clone git@github.com:vasyl-purchel/dl.sumdu.edu.ua.tech.sol.support.git
Cloning into 'dl.sumdu.edu.ua.tech.sol.support'...
warning: You appear to have cloned an empty repository.
Checking connectivity... done.
$ cd dl.sumdu.edu.ua.tech.sol.support/
```

2. Create new file "my name.txt" and commit it

```
$ touch 'vasyl purchel.txt'
$ git add vasyl\ purchel.txt
$ git commit -m'Adds new txt file to git repository'
[master (root-commit) 3d24cfa] Adds new txt file to git repository
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 vasyl purchel.txt
 ```

3. Check current state

```
$ git status
On branch master
nothing to commit, working directory clean
$ ls
vasyl purchel.txt
```

4. Modify created file and commit changes:

```
$ echo "making some changes" > vasyl\ purchel.txt
$ cat vasyl\ purchel.txt
making some changes
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        modified:   vasyl purchel.txt

no changes added to commit (use "git add" and/or "git commit -a")
$ git commit -a -m'Populates content for "vasyl purchel.txt"'
warning: LF will be replaced by CRLF in vasyl purchel.txt.
The file will have its original line endings in your working directory.
[master warning: LF will be replaced by CRLF in vasyl purchel.txt.
The file will have its original line endings in your working directory.
3f2a5a0] Populates content for "vasyl purchel.txt"
warning: LF will be replaced by CRLF in vasyl purchel.txt.
The file will have its original line endings in your working directory.
 1 file changed, 1 insertion(+)
$ git status
On branch master
nothing to commit, working directory clean
```

*Warnings are just saying that line endings will be replaces. This shouldn't happen
 on unix systems or can be prevented if configure git to use same line endings
 as you use in the system.*

5. Work with new branch:

```
$ git branch new-branch
$ git checkout new-branch
Switched to branch 'new-branch'
$ echo "some changes in new-branch" >> vasyl\ purchel.txt
$ touch branch.txt
$ git add branch.txt
$ git commit -a -m'Adds some changes in new branch'
warning: LF will be replaced by CRLF in vasyl purchel.txt.
The file will have its original line endings in your working directory.
[new-branch warning: LF will be replaced by CRLF in vasyl purchel.txt.
The file will have its original line endings in your working directory.
e658f2b] Adds some changes in new branch
warning: LF will be replaced by CRLF in vasyl purchel.txt.
The file will have its original line endings in your working directory.
 2 files changed, 1 insertion(+)
 create mode 100644 branch.txt
$ git status
On branch new-branch
nothing to commit, working directory clean
```

6. Working with tags

```
$ git tag -a firstTag -m "First tag"
$ git tag
firstTag
```

7. Check that master branch still untouched as we've been working on new-branch:

```
$ git checkout master
Switched to branch 'master'
$ ls
vasyl purchel.txt
```

8. Push work to github.com repository

```
$ git push --all
Counting objects: 9, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (4/4), done.
Writing objects: 100% (9/9), 819 bytes | 0 bytes/s, done.
Total 9 (delta 0), reused 0 (delta 0)
To git@github.com:vasyl-purchel/dl.sumdu.edu.ua.tech.sol.support.git
 * [new branch]      master -> master
 * [new branch]      new-branch -> new-branch
$ git push --tags
Counting objects: 1, done.
Writing objects: 100% (1/1), 169 bytes | 0 bytes/s, done.
Total 1 (delta 0), reused 0 (delta 0)
To git@github.com:vasyl-purchel/dl.sumdu.edu.ua.tech.sol.support.git
 * [new tag]         firstTag -> firstTag
```
