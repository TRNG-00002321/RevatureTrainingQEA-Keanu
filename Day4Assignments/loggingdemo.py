import logging

#only tracks logs of a specific level and above
#format helps identify what time and where the problem is happening and what kind of problem occurs
#can specify which logging level to exclude with level = logging.disable()
logging.basicConfig(filename="mylog.log", level=logging.WARNING, format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

logging.debug("This is a debug message")        #Level 1
logging.info("This is an info message")         #Level 2
logging.warning("This is a warning message")    #Level 3
logging.error("This is an error message")       #Level 4
logging.critical("This is a critical message")  #Level 5
