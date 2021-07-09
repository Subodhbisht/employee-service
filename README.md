# employee-service

```
Backend service to search employees to fetch the record from mysql dbms
```

# Get Employees by search criteria
```
curl -X POST \
     http://localhost:8081/employees/search \
     -H 'Content-Type: application/json' \
     -d '{"name":"bisht"}
```
### HTTP OK

```
[
   {
      "empId":"1",
      "empCode":"51803090",
      "firstName":"Subodh",
      "lastName":"Bisht",
      "jobTitle":"Tech Lead",
      "age":30,
      "startDate":"2019-04-08",
      "endDate":"2021-07-16"
   },
   {
      "empId":"5",
      "empCode":"PHI001",
      "firstName":"Sudarshan",
      "lastName":"Bisht",
      "jobTitle":"Social Worker",
      "age":35,
      "startDate":"2012-04-08",
      "endDate":"2021-07-16"
   },
   {
      "empId":"9",
      "empCode":"71803090",
      "firstName":"Bisht",
      "lastName":"Amit",
      "jobTitle":"Ass. Developer",
      "age":27,
      "startDate":"2016-04-08",
      "endDate":"2021-07-16"
   }
]
```
