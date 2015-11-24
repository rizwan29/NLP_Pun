import requests
import BeautifulSoup
import re 
from collections import Counter
def wow_tokenize(string):
	wordList = re.sub("[.][^A-Za-z0-9]|[" "]|[,]|\.$", " ",  string).split()
	count=Counter(wordList)
	print count
session=requests.session()
url = raw_input("Enter a website to extract the URL's from: ")
req=session.get(url,verify=False)
doc=BeautifulSoup.BeautifulSoup(req.content)
ls=[]
for i in doc.findAll('p'):
	ls.append(i.text)
	
s=""
s=s.join(ls) 
wow_tokenize(s)
