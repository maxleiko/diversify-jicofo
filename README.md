# Diversify Jicofo example

The idea here, is to be able to create *valid* mutants of a Java project called [Jicofo](https://github.com/jitsi/jicofo).  
To do so, we will use [diversify-mvn](https://github.com/maxleiko/diversify-mvn), a JavaScript tool that allow us to do just that.

> You need **Git**, **Node.js** and **Maven** in order to do this tutorial

## Setup of the environment
Create a directory and go into it:
```sh
mkdir diversify-jicofo
cd diversify-jicofo
```

Clone the Java project `jicofo` using `git`:
```sh
git clone git@github.com:jitsi/jicofo.git
```

Install `diversify-mvn` using `npm`:
```sh
npm i -g diversify-mvn
```

## Configuration
In order to use `diversify-mvn` you have to give it a config file as its one and only parameter:  

```sh
diversify-mvn jicofo.json
```

So we have to create this file:

```sh
touch jicofo.json
```

Open you favorite editor and copy/paste this into `jicofo.json`:
```json
{
  "appPath": "jicofo",
  "versionsCount": 5,
  "outputDir": ".results",
  "overwriteContainer": true,
  "engines": [
    { "host": "10.0.0.1", "port": 2375 },
    { "host": "10.0.0.3", "port": 2375 },
    { "host": "10.0.0.4", "port": 2375 },
    { "host": "10.0.0.5", "port": 2375 },
    { "host": "10.0.0.6", "port": 2375 },
    { "host": "10.0.0.7", "port": 2375 }
  ],
  "blacklist": [],
  "containerOptions": {
    "VolumeDriver": "nfs",
    "Binds": ["10.0.0.1/opt/data/leiko/.m2:/root/.m2:rw"]
  }
}
```

> Adapt the `"engines": []` and `"containerOptions": {}` configurations to match your Docker setup

## Tell diversify-mvn what to do
What `diversify-mvn` will do is:
 - create a mutant of the original `jicofo` project by randomly change the dependencies versions
 - create a Docker image of that mutant using the Dockerfile at the root of the `jicofo` project (**you have to add that, see below**)
 - run that mutant Docker image and see if it fails (if the exit code of the Docker container is **0** then the mutant is **valid**)

So we need to add a `Dockerfile` to the `jicofo` project.  
Let's do something simple to test the validity of the mutant: **just run the tests :)**

Go into the `jicofo` project and create a Dockerfile:
```sh
cd jicofo
touch Dockerfile
```

Open the `Dockerfile` with your favorite editor and copy/paste this:
```Dockerfile
FROM     maven:3.5.0-jdk-8-alpine

ADD      . /usr/src/app
WORKDIR  /usr/src/app
CMD      ["mvn", "test"]
```

Go back
```sh
cd ..
```

## Diversify it
Alright, you can now start the process and grab a coffee, because it will take forever to complete all the possible mutations (13^6)
```sh
╭leiko@kevtop2 /tmp/diversify-jicofo ‹master*›
╰➤ diversify-mvn jicofo.json 
Dependencies:   26
Groups:         13
Artifacts:      26
Versions:       85
Mutants limit:  13^6
```

`Ctrl+C` out when you feel that you have enough valid mutants :)