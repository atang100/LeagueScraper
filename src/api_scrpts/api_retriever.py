import requests
import settings

GET_SUMMONERS_BY_NAME_URL = 'https://na.api.pvp.net/api/lol/{}/v1.4/summoner/by-name/{}'
GET_RECENT_GAMES_BY_SUMMONER_ID_URL = 'https://na.api.pvp.net/api/lol/{}/v1.3/game/by-summoner/{}/recent'

api_key_obj = {'api_key': settings.api_key}

def get_summoners_by_name(summoners, region):
    summoners_csv = ','.join(summoners)
    response = requests.get(GET_SUMMONERS_BY_NAME_URL.format(region, summoners_csv), params=api_key_obj).json()
    summoners_list = []
    for key, value in response.items():
        summoners_list.append(value)
    print(summoners_list)
    return summoners_list

def get_recent_matches_by_id(summoner_id, region):
    response = requests.get(GET_RECENT_GAMES_BY_SUMMONER_ID_URL.format(region, summoner_id), params=api_key_obj).json()
    return response['games']

def test():
    summoners = get_summoners_by_name(['petergregorypp'], 'NA')
    for summoner in summoners:
        summoner_id = str(summoner['id'])
        response = get_recent_matches_by_id(summoner_id, 'NA')
        print(response)

if __name__ == '__main__':
    test()
