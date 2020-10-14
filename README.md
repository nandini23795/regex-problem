# Regex Problem

Build a simple Java Spring REST api for regex match, which will have one api as follows:
* Post Api: /api/\{regex}/\{textBody} that must response in following ways:
    * If regex present in the textBody:
      {"match": "regex", "error": false}
    * If regex not present in the textBody:
      {"match": "null", "error":false}
    * If regex is bad regex and throw PatternSyntaxException:
      {"match": "null", "error":true}

# Clone project to your local directory

`git clone https://github.com/nandini23795/regex-problem.git `

# Build your project :  

`mvn clean install`

# Run your project :  

Using the URL:

`localhost:8090/api/:regex/:textBody`

Input: {
        regex: "hello",
        textBody: "hello world"
      }

Will return the following result:

Output:    {
            match: "hello",
            error: "false"
          }
