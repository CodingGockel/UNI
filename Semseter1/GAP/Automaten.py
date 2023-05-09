class Automat():
    def __init__(self,input):
        self.input=input
        self.rules=[]
        self.end=True
        self.index=0
    def addRule(self,zustand,terminal,step):
        self.rules.append(Rule(zustand,terminal,step))
    def getOutput(self):
        currentRule=self.rules[0]
        while (self.end):
            currentZustand=currentRule.zustand
            
        
        
class Rule():
    def __init__(self,zustand,terminal,step):
        self.zustand=zustand
        self.terminal=terminal
        self.step=step
