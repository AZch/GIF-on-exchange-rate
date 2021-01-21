# GIF on exchange rate
## App
1. docker build -t gif_on_rate .  
2. docker run --name gif_on_rate -d --rm -p 8080:8080 gif_on_rate

## application.yml
exchange: - base data for exchange feign client
  name - name feign client
  currency:
    base - base currency (not working in free mode, try my: 571488d5e4184828bc1ef9929751e42d)
    compare - compare currency to base
  api:
    key - api key to connect to external api
    urls
      base - base url for external api
      latest - latest url
      historical - historical url
gif: - base data for gif feign client
  name - name feign client 
  api:
    key - key for gif api (try my: 9QXn7scFsJBq7KbvQNK5GMYr7gsWCXk3)
    urls:
      base - base url for external api
      rich - rich url gif
      broke - broke url gif


 

