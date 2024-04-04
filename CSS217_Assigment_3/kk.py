import json

class DatabaseConnection:
    _instance = None

    @staticmethod
    def get_instance():
        if DatabaseConnection._instance is None:
            DatabaseConnection()
        return DatabaseConnection._instance

    def __init__(self):
        if DatabaseConnection._instance is not None:
            raise Exception("This class is a singleton!")
        else:
            DatabaseConnection._instance = self
            self._connection_info = self.load_connection_info()

    def load_connection_info(self):
        config_file_path = "/path/to/config.json"
        with open(config_file_path, "r") as config_file:
            connection_info = json.load(config_file)
        return connection_info

    def connect(self):
        connection_info = self._connection_info

    def execute_query(self, query):
        pass

    def get_connection_info(self):
        return self._connection_info

def main():
    connection = DatabaseConnection.get_instance()
    connection.connect()
    query = "SELECT * FROM table_name"
    result = connection.execute_query(query)
    print(result)
    connection_info = connection.get_connection_info()
    print(connection_info)

if __name__ == "__main__":
    main()  