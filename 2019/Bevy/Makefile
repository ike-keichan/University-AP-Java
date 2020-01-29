TARGET	= MakefileDiver
SCRIPT	= $(TARGET).sh
ARCHIVE	= $(shell basename `pwd`)

all: $(SCRIPT)
	sh ./$(SCRIPT)

clean: $(SCRIPT)
	sh ./$(SCRIPT) clean

test: $(SCRIPT)
	sh ./$(SCRIPT) test

install: $(SCRIPT)
	sh ./$(SCRIPT) install

doc: $(SCRIPT)
	sh ./$(SCRIPT) doc

wipe: clean
	@find . -name ".DS_Store" -exec rm {} ";" -exec echo rm -f {} ";"
	(cd ../ ; rm -f ./$(ARCHIVE).zip)

zip: wipe
	(cd ../ ; zip -r ./$(ARCHIVE).zip ./$(ARCHIVE)/ --exclude='*/.svn/*')
