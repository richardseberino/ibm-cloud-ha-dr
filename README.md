# IBM Cloud HA & DR
Describe usage of principals like High Availability and Disaster Recovery at IBM Cloud

This is an how-to tutorial, step-by-step, about how to deploy a sample application using 3 different approaches: Kubernetes/OpenShift, Function As a Service (Code Engine) and tradicional Virtual Machines. 

This tutorial is split in 4 steps:

### 1 - Provision the infrastruture
1.1 - Setup VPC and subnets at DR and Production regions
1.2 - Provision OpenShift Cluster
1.3 - Provision Code Engine namespace
1.4 - Provision PostgreSQL
1.5 - Provision Redis
1.6 - Provision 8 Virtual Machines
      - 6 for applications (3 per region, and each machine in his own Availability zone
      - 1 for Instana (Production region)
      - 1 for LDAP (Production region)

### 2 - Configure the infrastructure
2.1 - Configure Virtual Machines 
2.2 - Install Clod Pak for Integration
2.3 - Configurar Navigator + API Connect
2.4 - Configure replication between PostgreSQL Prod and DR
2.5 - Create Application Load balancer for Production and DR (for both applications: sessao and cliente) 
2.6 - Registry the APIs endpoints in the API Connect
2.7 - Registry an Application demo to consume those APIs

### 3 - Deploy the application
3.1 - Create the DevSecOps pipeline to deploy the application in all environments
3.2 - Adjust the fron-end application endpoints to use the API connect endpoints 
3.3 - Create the COS for each application case (openShift, codeEngine and VMs) for each environment (prod and DR)
3.4 - Test each application case/flavor per site using local COS URL
3.5 - Configure Global Load Balancer

### 4 - Setup Monitoring
4.1 - Configure IBM Cloud Monitoring
4.2 - Configure LogDNA
4.3 - Configure Instana


