# Welcome to Altair GraphQL Client.
# You can send your request using CmdOrCtrl + Enter.

# Enter your graphQL query here.
mutation {
  createContact(request:{
    firstName: "Chirag"
    lastName: "Desai"
    birthDate: "07-11-1981"
    email: "chirag.desai@mybadluck.com"
    address: {
      street: "90 Jubilee Dr"
      suburb: "Jordan Springs"
      state: "NSW"
      postCode: "2747"
    }
    phones: [
      {
        phoneType: "Mobile"
        phoneNumber: "0402-234-908"
      },
      {
        phoneType: "Home"
        phoneNumber: "02-468-324-34"
      },
      {
        phoneType: "Office"
        phoneNumber: "02-989-333-22"
      }
    ]
  }) {
    id
    firstName
    lastName
    birthDate
    email
    phones {
      phoneType
      phoneNumber
    }
    address {
      street
      suburb
      state
      postCode
    }
    fullName
  }
}