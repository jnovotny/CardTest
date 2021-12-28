  Design and implement a REST API to return a feed of "cards" - a simple JSON representation of the payload is sufficient

 Cards can be of different types and include different values. Please implement the below logic:

     Daily quote card - will show a different quote every day. the list of quotes will be stored in the database or a file for this exercise. The card will include:
         Title - "Daily Quote"
         Message - the quote content. You can use "quote1", "quote2", "quote3" for the exercise.
         Author - the author of the daily quote. You can use "author1", "author2", etc.
     Status update card - will be used to show updates to customers. This card will include:
         Title - String - "Important Security Update"
         Icon - String - e.g. https://tinyurl.com/y5mdph2g
         Message - String - e.g. "For your security, we support 2 factor authentication, and would recommend that you turn it on."
         Button - String - e.g. "Got it, thanks"

 Each card type can have multiple implementations

     Each implementation will allow for a pre-defined condition to determine whether the card should be presented to a given customer. E.g. if the number of seconds on the request timestamp is even, show. Else - do not show the card to this customer.

