#Плагин на религии
#Связь с разработчиком:
# - https://vk.com/te4hnoplus
# - Te4hnoPlus@yandex.ru

#Индитификаторы поддерживаемой еды:

#BREAD PORK MUSHROOM_SOUP SPIDER_EYE PUMPKIN_PIE
#COOKIE MELON RAW_BEEF COOKED_BEEF POISONOUS_POTATO
#RAW_FISH COOKED_FISH COOKED_CHICKEN POTATO_ITEM MUTTON
#APPLE GRILLED_PORK GOLDEN_APPLE BAKED_POTATO COOKED_RABBIT
#RAW_CHICKEN ROTTEN_FLESH CARROT_ITEM RABBIT RABBIT_STEW

#Управление балансом

NeedMoney_Set: 100
NeedMoney_ReSet: 200

#Сообщения в чате

Message_Help: "Помогите котику("
Message_False: "Ошибка конКОТЭнации"
Message_Set: "Религия выбрана"
Message_ReSet: "Религия перевыбрана"
Message_Wrong: "Данной религии не существует"
Message_Success: "Ваша религия изменена"
Message_NoMoney: "Вам не хватает бабла"

#Список доступных религий

Religions_List:
  #Данное можно получить через %religions_name%
  - Defаult
  - Tester

#Расширение для религий

Defаult:
    #Данную строку можно получить через %religions_imeg%
    imeg: "Тест"
    
    #Защитный эффект у игроков, определенной религии.
    resist: " minecraft:health_boost 10 2"
    
    #Аргументы для команды /effect give <Player> 
    #Пробел в начале строки обязателен! 
    #Мне лень делать дубликат конфига с исправленными строками
    #Так что прошу писать изначально правильно
    
    BREAD: " minecraft:health_boost 10 2"
    
    
    
    