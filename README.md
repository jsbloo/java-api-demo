# Java API demo project

Hello curious reader, welcome to my Java API demo project. Built using Spring Boot. 

### Why did I build this?

The purpose of this project, is to define a skeleton API that can be repurposed for different use cases.

I am interested in aviation, so I have used the current basis of the API to store information about various historical and modern aircraft,
however this project can be easily repurposed to _Create, Read, Update_ and _Delete_ any form of data. 
I have tried to stick to best practices, when developing this skeleton API. Utilizing DTO's, Controller / Service structure 
and an extensive integration and unit testing suite.

### How I expected the challenge to go 
I have had some brief experience working on a C# API before, so a lot of the concepts and design patterns explored when working on this project where
not entirely new to me. However, I still learnt a lot when working on this project. I learnt about the use of DTO's, and the intricacies of Spring Boot.
I also learned how to use Mockito effectively.

I expected to be able to define the MVP, slightly faster than I was able to. I ran into a lot of roadblocks a long the way, which took some time to figure out.
However overall, I am happy with the finished project. It provides a good foundation, for further implementation; and I learned a lot along the way.

### What went well? / What didn't go as planned?
Overall, I think the development process went well. I was able to quickly implement basic CRUD functionality, and connect to a mySQL database. 
Proving how powerful of a tool Spring Boot is, in only an afternoon I had an up-and-running simple API.

I did run into various headaches, and time sinks. I should have stuck to my MVP more rigidly at first, I wasted a lot of time trying to implement a one to many relations that was mostly superfluous. I also tried to implement a PATCH request for my update method, I spent a lot of time reading about something that wasn't 
that important in the grand scheme of the overall projects purpose. 

I also ran into many small issues that became time sinks, such as dealing with JSON Arrays when testing, SQL syntax issues (Using " instead of ') and issues with 
auto incremental ids when testing. 

One interesting issue I faced, was a recursive loop when adding a plane to an airport. I found out this was caused by the ModdelMapper when serializing,
I fixed this using the ``` @JsonBackReference ``` annotation. 

### Possible improvements
I didn't get time to fully implement my one to many, airport to plane relation. I have only implemented, a method to add a plane to an airport. In the future I will, add more functionality to this. I also planed on a battle and travel feature. So planes could fight each other and travel between airports. If I had another week to work on this, I would implement these features.

I would also improve how PrimaryUsers and Armament are handled, their current implementation works but it is a bit buggy. A better many to one relation, implementation would have been better.

I could also make my tests more extensive, testing for edgecases and failures. Instead of just expected functionality. 

I did not spend much time, writing my Jira Stories. They are fine for me to understand, but if I was working In a team I would make sure these are more defined. The same 
can be said for my pull request comments. 

## Test Coverage
![image](https://user-images.githubusercontent.com/16117428/143503826-9a0cbfb2-4e25-4870-abb4-483810f0b40a.png)



## Requests 

When you clone the project, if you direct to: http://localhost:8080/swagger-ui/index.html#/ this will display a nice list of all the available requests. 

## MilitaryPlane requests 
<b>Click the drop downs to see usage</b>

<details>
  <summary>createMp </summary>
  
![image](https://user-images.githubusercontent.com/16117428/143440485-60bdacc9-805c-4835-a580-89d2fb3272e1.png)
![image](https://user-images.githubusercontent.com/16117428/143440688-e9611788-202e-466d-94a7-14d3c78548d2.png)
![image](https://user-images.githubusercontent.com/16117428/143440567-c9e5e627-882c-4696-9c8e-64df87b6d153.png)

### Can also handle JSON Array, of Objects:
![image](https://user-images.githubusercontent.com/16117428/143441806-5e5c81f3-6f78-4f2a-a38d-4dc1cc867f8a.png)
![image](https://user-images.githubusercontent.com/16117428/143441939-6625b21e-3459-4330-83f5-39afb7323b1e.png)
  
  ### Persistance 
![image](https://user-images.githubusercontent.com/16117428/143450065-495e2479-1043-4445-9292-1e8fb9af5621.png)
![image](https://user-images.githubusercontent.com/16117428/143450190-a716c5fe-fcae-4773-ac83-0740e75eefa0.png)
![image](https://user-images.githubusercontent.com/16117428/143450287-ca3c0cbb-2be6-43fc-990e-62ebd98b4e77.png)
</details>

<details>
  <summary>readByIdMp</summary>

![image](https://user-images.githubusercontent.com/16117428/143442131-18b1e84a-641e-4e73-bf1e-5b9ec807050b.png)
![image](https://user-images.githubusercontent.com/16117428/143442251-a9f60312-fc0c-4b79-97a8-fe06c7b965d7.png)
![image](https://user-images.githubusercontent.com/16117428/143442321-12df8fab-8bb1-40b5-913c-68e4f3c1cf5d.png)
  
 </details>
 
 <details>
  <summary>readAllMp</summary>

![image](https://user-images.githubusercontent.com/16117428/143442454-52558079-4dee-4f11-a9e1-34f0e753c7f2.png)
</br>
![image](https://user-images.githubusercontent.com/16117428/143442537-8b6aa831-dc67-4e35-8d34-52557d70d2ee.png)
</details>

<details>
  <summary>deleteById</summary>

![image](https://user-images.githubusercontent.com/16117428/143442614-ca3ea0b6-b43e-4ce0-b5c9-83c870ab53bc.png)
![image](https://user-images.githubusercontent.com/16117428/143442865-e2cdcafb-199f-4c00-b4e8-610b15e88d62.png)
![image](https://user-images.githubusercontent.com/16117428/143442911-c4210797-8647-4828-87f9-6391c87c4eb0.png)
### Now if we try to get deleted id:
![image](https://user-images.githubusercontent.com/16117428/143443117-71472277-fb0f-4afc-96e8-7ca7e5d090b4.png)
![image](https://user-images.githubusercontent.com/16117428/143443162-5f86e024-f9a6-465c-9db3-8e3aafb67e35.png)
 
  ### Persistance
  ![image](https://user-images.githubusercontent.com/16117428/143450566-8f7c29b1-3618-4d50-bd61-5df79cb20a9f.png)

</details>

<details>
  <summary>updateMp</summary>
  
![image](https://user-images.githubusercontent.com/16117428/143443617-f20a4477-7790-43b7-a71b-0bb95762f292.png)
![image](https://user-images.githubusercontent.com/16117428/143443737-12e4a432-6d40-479d-ae62-06ce9254d9ab.png)
![image](https://user-images.githubusercontent.com/16117428/143443785-ff6cf6fa-bc52-4de8-99c6-30f7a59f5d9d.png)
### If we get id 2, to check update. You can see modelName:P50 changed to P51
![image](https://user-images.githubusercontent.com/16117428/143443962-4abf974f-41cb-4dd5-a130-bf9ca60ec0ea.png)
![image](https://user-images.githubusercontent.com/16117428/143444005-1e936d7e-cbf6-4e73-80a8-0908aab39502.png)
  
  ### Persistance 
  
  ![image](https://user-images.githubusercontent.com/16117428/143453180-afccbfca-3a6e-49c8-bf42-585cf4d29c13.png)

  </details>
  
  <details>
  <summary>readByNameMp</summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143453973-5f04abdd-7f50-4e84-99f2-d089fd14bd6b.png)
  ![image](https://user-images.githubusercontent.com/16117428/143454204-570c345a-1527-4435-b768-bbe83ee62927.png)
  ![image](https://user-images.githubusercontent.com/16117428/143454250-0b11a47c-8a4a-4199-9771-0c37084a8a40.png)
  
  </details>
  
  <details>
  <summary>readByNameNationalOriginMp</summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143454436-adb125f5-e94b-4d85-84d2-ec3a90bb61e3.png)
  ![image](https://user-images.githubusercontent.com/16117428/143454469-3a61b7f4-676d-4453-a9d0-33a28e13e868.png)
  ![image](https://user-images.githubusercontent.com/16117428/143454507-382d8b39-7b6c-4fe1-b1a4-f9693782bb9e.png)
  
  </details>
  
  ## Airport Requests 
  <details>
  <summary> createAirport </summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143511375-ae559ba8-ca02-4413-bb04-593f77bccf32.png)
  ![image](https://user-images.githubusercontent.com/16117428/143511468-afc21130-5c68-44da-aa15-5e12236c40f2.png)
  
  ### Persistance
  
  ![image](https://user-images.githubusercontent.com/16117428/143511497-01addca6-3bfa-4c65-abbf-24390e78b458.png)
  
  </details>
  
  <details>
  
  <summary> readAllAirport </summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143511610-9b2fadda-3ef9-4bfc-a6f5-fa8006986915.png)
  ![image](https://user-images.githubusercontent.com/16117428/143511643-2bf54f04-d694-4f39-963a-abba75c336d5.png)
 
  </details>
  
  <details>
  
  <summary> readByAirportCode </summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143511726-6980dd9a-981a-45af-9107-4741fea749d0.png)
  ![image](https://user-images.githubusercontent.com/16117428/143511751-b49bbce4-c31c-46f6-9c7a-15bccac69f1a.png)
  
  </details>
  
  <details>
  
  <summary> updateAirport </summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143512487-dc1733d4-c3e4-4749-9ad8-8c9274f8483f.png)
  
  ### Persistance 
  
  ![image](https://user-images.githubusercontent.com/16117428/143512536-9234fffc-eed0-48ef-9138-302fb0418e5d.png)
  
  </details>
  
  <details>
  
  <summary>deleteAirport</summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143512629-78a86aa3-1d54-4236-97b5-79def3f9004e.png)
  ![image](https://user-images.githubusercontent.com/16117428/143512648-7b2afea0-431c-4e88-a6df-4859f7726599.png)
  
  ### Persistance
  
  ![image](https://user-images.githubusercontent.com/16117428/143512678-bfbed119-58c3-43bf-9008-c02298a86604.png)
 
  </details>
  
  <details>
  
  <summary> addMpToAirport </summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143512803-c4e57f07-13d1-4368-a707-5e72d78d221a.png)
  ![image](https://user-images.githubusercontent.com/16117428/143513514-84bc4379-f03f-4b0f-b1c5-e1ce20eb4349.png)

  ### Persistance
  
  ![image](https://user-images.githubusercontent.com/16117428/143513543-59a68aad-99bd-420f-8858-ed3f4de88117.png)
  
  </details>

  ## ERD
  
  <details>
  <summary> show ERD </summary>
  
  ![image](https://user-images.githubusercontent.com/16117428/143498704-1b695bc7-43a4-46b4-8716-6b83c5d30f87.png)
  </details>
  
  ## Risk Assesment
   <details>
  <summary> Risk Assesment.pdf File</summary>
  
  [ra-pdf.pdf](https://github.com/jsbloo/java-api-demo/files/7605187/ra-pdf.pdf)

  </details>
  
## Jira
  
<details>
  <summary> Link to Jira </summary>
  
https://joshuaqa123.atlassian.net/jira/software/projects/QAP/boards/6/backlog?selectedIssue=QAP-62
  
</details>


Note to marker, please look through my commit history. My network graph is buggy.




