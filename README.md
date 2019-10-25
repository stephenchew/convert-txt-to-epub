# Convert text file into epub format

## Use Java to break down text into multiple files
Java will read line by line (to avoid out of memory) into multiple files with respective format (HTML). The files will be stored in `output` directory.

* Title stored as `*.txt` file
* Content stored as `*.html` file

## Use JavaScript to convert Java output files into single epub 
JavaScript will then pick up the respective files from `output` folder and consolidate them into a JSON object, then passed into a node module to be converted into an epub file.

## Use epub to mobi online converter
– As per title –