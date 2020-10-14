# Regex Problem

Build a simple Java Spring REST api for regex match, which will have one api as follows:
* Post Api: /api/\{regex}/\{textBody} that must response in following ways:
    * If regex present in the textBody:
      {"match": "regex", "error": false}
    * If regex not present in the textBody:
      {"match": "null", "error":false}
    * If regex syntax is bad and throw InterruptedException:
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
          
 # Catastrophic backtracking Problem : 
 
 Catastrophic backtracking is a condition that can occur if you’re checking a (usually long) string against a complex regular expression. The problem usually occurs if something towards the end of the string causes the string to not match.
 To avoid this problem, we can make use of thread. For a specific time, we can check the string against a complex regular expression. If it's taking long time, we can interrrupt the thread and stop the process. So that way, we can avoid some memory performance issue. 
