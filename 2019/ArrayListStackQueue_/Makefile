ANT	= env LC_ALL=ja_JP.UTF-8 ant
ARCHIVE	= $(shell basename `pwd`)

all:
	$(ANT) all

clean:
	$(ANT) clean

test:
	$(ANT) test

install:
	$(ANT) install

doc:
	$(ANT) doc

zip: clean wipe
	(cd ../ ; zip -r ./$(ARCHIVE).zip ./$(ARCHIVE)/)

wipe:
	(cd ../ ; rm -f ./$(ARCHIVE).zip)