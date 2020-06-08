class ModeloPDM:
    '''
    classdocs
    '''
    
    def S(self):
        raise NotImplementedError

    def A(self, estado):
        raise NotImplementedError
    
    def T(self, s, a):
        raise NotImplementedError
    
    def R(self, s, a, sn):
        raise NotImplementedError
