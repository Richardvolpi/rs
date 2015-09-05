# What
A collection of Runescape Classic artifacts, mostly from the auto'ing community. It's a clone of http://rscdump.com/, but extracted.

# Why
http://rscdump.com/ is a good collection of RSC artifacts, but since it's just a set of nested ZIPs, it isn't easiy searchable, and isn't indexed by search engines. This repo is!

# How
Urgh.

1. `wget -r http://rscdump.com/`
2. Compute `SHA256SUMS`
3. Repeatedly execute `recursively-extract-archives` until the only archives that are found are "Skipped". This creates a commits for each extracted archive file.
4. Optionally, purge your Git repo of archive files, using https://rtyley.github.io/bfg-repo-cleaner/ : `java -jar bfg.jar --delete-files '*.rar' .`

I saved the BFG reports in `..bfg-report` in case anyone wants to read. I haven't looked at what it contains.
